Ext.define('LE.view.customers.CustomerForm', {
    extend: 'Ext.form.Panel',
    bodyPadding: 5,
    width: 800,
    //frame: true,
    //title: loc.customers.addClient,
    fieldDefaults: {
        labelWidth: 180,
        labelAlign: 'right',
        anchor: '100%'
    },
    constructor: function (cfg) {
        cfg = cfg || {};
        var me = this;

        var typeStore = Ext.create('Ext.data.Store', {
            fields: ['id', 'name'],
            data: [
                { id: 1, name: '1'},
                { id: 2, name: '2'}
            ]
        });

        var genderStore = Ext.create('Ext.data.Store', {
            fields: ['id', 'name'],
            data: [
                {id: 0, name: 'აირჩიეთ...'},
                {id: 1, name: 'მამრობითი'},
                {id: 2, name: 'მდედრობითი'}
            ]
        });
        var statusStore = Ext.create('Ext.data.Store', {
            fields: ['id', 'name'],
            data: [
                { id: 1, name: 'VIP კლიენტი'},
                { id: 2, name: 'შავი სია'},
                { id: 3, name: 'ნორმალური'},
                { id: 4, name: 'ახალი'},
                { id: 5, name: 'სხვა'}
            ]
        });


        var fieldset1 = Ext.create('Ext.form.FieldSet', {
            border: false,
            defaults: {
                xtype: 'textfield'
            },
            items: [{
                xtype: 'combo',
                fieldLabel: loc.type,
                name: 'customerType',
                store: typeStore,
                displayField: 'name',
                valueField: 'id',
                queryMode: 'local',
                editable: false
            }, {
                fieldLabel: loc.customers.legalName,
                name: 'fullName',
                hidden: true
            }, {
                fieldLabel: loc.customers.personalNo,
                name: 'personalNo',
                vtype: 'personalno'
            }, {
                xtype: 'combo',
                fieldLabel: loc.status,
                name: 'status',
                //disabled: true,
                displayField: 'name',
                valueField: 'id',
                queryMode: 'local',
                editable: false,
                store: statusStore
            }]
        });

        var fieldset2 = Ext.create('Ext.form.FieldSet', {
            border: false,
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
            bodyPadding: 15,
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
            // TODO მისამატებელია ატრიბუტები
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
                personalNo.hide();
                firstName.hide();
                lastName.hide();
                birthDate.hide();
                gender.hide();
                fullName.show();
            } else {
                personalNo.show();
                firstName.show();
                lastName.show();
                birthDate.show();
                gender.show();
                fullName.hide();
            }
        }
        function openPhoto(){
            Ext.create('LE.view.customers.FileWindow', {
                customerForm: me
            });
        }
    }
});