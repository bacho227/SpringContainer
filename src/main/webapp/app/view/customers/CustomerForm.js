Ext.define('LE.view.customers.CustomerForm', {
    extend: 'Ext.form.Panel',
    bodyPadding: 5,
    margin: 5,
    width: 700,
    //frame: true,
    //title: loc.customers.addClient,
    fieldDefaults: {
        labelWidth: 150,
        labelAlign: 'right',
        anchor: '100%'
    },
    constructor: function (cfg) {
        cfg = cfg || {};
        var me = this;

        var typeStore = Ext.create('LE.store.customers.TypeStore');
        var statusStore = Ext.create('LE.store.ParamStore');
            statusStore.setHeader('CUSTOMER_STATUS');
        var genderStore = Ext.create('LE.store.GenderStore');


        var fieldset1 = Ext.create('Ext.form.FieldSet', {
            border: false,
            flex: 1,
            defaults: {
                xtype: 'textfield'
            },
            items: [{
                xtype: 'combo',
                fieldLabel: loc.type,
                name: 'customerType',
                store: typeStore,
                displayField: 'descrip',
                valueField: 'id',
                queryMode: 'local',
                editable: false
            }, {
                fieldLabel: loc.customers.legalName,
                name: 'fullName'
                //hidden: true
            }, {
                fieldLabel: loc.customers.personalNo,
                name: 'personalNo',
                vtype: 'personalno'
            }, {
                xtype: 'combo',
                fieldLabel: loc.status,
                name: 'status',
                //disabled: true,
                displayField: 'descrip',
                valueField: 'id',
                editable: false,
                store: statusStore
            }]
        });

        var fieldset2 = Ext.create('Ext.form.FieldSet', {
            border: false,
            flex: 1,
            defaults: {
                xtype: 'textfield'
            },
            items: [{
                fieldLabel: loc.customers.firstName,
                name: 'firstName',
                vtype: 'name'
            }, {
                fieldLabel: loc.customers.lastName,
                name: 'lastName',
                vtype: 'name'
            }, {
                xtype: 'datefield',
                fieldLabel: loc.customers.birthDate,
                name: 'birthDate',
                vtype: 'birthdate'
            }, {
                xtype: 'combo',
                name: 'gender',
                fieldLabel: loc.customers.gender,
                store: genderStore,
                displayField: 'name',
                valueField: 'id',
                queryMode: 'local',
                editable: false
            }, {
                xtype: 'hiddenfield',
                name: 'photo'
            }]
        });

        var extraFieldset = Ext.create("LE.view.customers.ExtraFieldset");

        var attributesFieldset = Ext.create('LE.view.customers.AttributesFieldset');

        me.items = [{
            xtype: 'fieldcontainer',
            layout: 'hbox',
            padding: 5,
            items: [{
                xtype: 'radio',
                name: 'isJuridical',
                boxLabel: 'ფიზიკური',
                checked: true,
                inputValue: 0,
                width: 120
            }, {
                xtype: 'radio',
                name: 'isJuridical',
                inputValue: 1,
                boxLabel: 'იურიდიული',
                listeners: {
                    change: function(f, val){
                        changeType(val);
                    }
                }
            }]
        }, {
            xtype: 'panel',
            border: false,
            layout: 'hbox',
            bodyPadding: '0 15 0 15',
            items: [fieldset1, fieldset2 ]
        }, extraFieldset, attributesFieldset];

        me.buttons = [{
            xtype: 'button',
            text: loc.customers.file,
            handler: openPhoto
        }, '->', {
            text: loc.reset,
            handler: reset
        }, {
            text: loc.save,
            glyph: g.get(g.save),
            handler: save
        }];

        me.callParent(arguments);

        changeType();

        function save(){
            if(!me.isValid()) return ;
            var customer = me.getForm().getValues();
            customer.isResident = customer.isResident ? 1 : 0;
            correctDates(customer, ['birthDate', 'docIssueDate', 'docValidDate']);
            delete customer.attributes;
            var attributes = attributesFieldset.getValues();
            var obj = {
                customer: customer,
                customerAttrValues: attributes
            };
            log(obj);

            myRequest({
                url: '/rest/customer/saveCustomer',
                jsonData: obj,
                callback: function(){
                    Ext.Msg.alert(loc.status, loc.customers.success);
                }
            });
        }

        function reset(){
            me.reset();
        }

        function changeType(isLE){ // isLegalEntity
            var personalNo = me.down('[name=personalNo]');
            var firstName = me.down('[name=firstName]');
            var lastName = me.down('[name=lastName]');
            var birthDate = me.down('[name=birthDate]');
            var gender = me.down('[name=gender]');
            var fullName = me.down('[name=fullName]');

            personalNo.allowBlank = !!isLE;
            firstName.allowBlank = !!isLE;
            lastName.allowBlank = !!isLE;
            birthDate.allowBlank = !!isLE;
            gender.allowBlank = !!isLE;
            fullName.allowBlank = !isLE;

            if(isLE) { // isLegalEntity
                personalNo.disable();
                firstName.disable();
                lastName.disable();
                birthDate.disable();
                gender.disable();
                fullName.enable();
            } else {
                personalNo.enable();
                firstName.enable();
                lastName.enable();
                birthDate.enable();
                gender.enable();
                fullName.disable();
            }
        }
        function openPhoto(){
            if(!me.fileWindow) {
                me.fileWindow = Ext.create('LE.view.customers.FileWindow', {
                    customerForm: me
                });
            }
            me.fileWindow.show();
        }
    }
});