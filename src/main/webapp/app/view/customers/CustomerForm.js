Ext.define('LE.view.customers.CustomerForm', {
    extend: 'Ext.form.Panel',
    //bodyPadding: 5,
    width: 800,
    //frame: true,
    //title: loc.customers.addClient,
    fieldDefaults: {
        labelWidth: 180,
        labelAlign: 'left',
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
                name: 'type',
                store: typeStore,
                displayField: 'name',
                valueField: 'id',
                queryMode: 'local',
                editable: false
            }, {
                fieldLabel: loc.customers.personalNo,
                name: 'personalNo',
                vtype: 'personalno'
            }, {
                xtype: 'combo',
                fieldLabel: loc.status,
                name: 'status',
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
            }]
        });

        var extraFieldset = Ext.create("LE.view.customers.ExtraFieldset");

        me.items = [{
            xtype: 'panel',
            border: false,
            layout: 'hbox',
            bodyPadding: 15,
            items: [ fieldset1, fieldset2 ]
        }, extraFieldset];

        me.buttons = [{
            text: loc.reset,
            handler: reset
        }, {
            text: loc.save,
            glyph: g.get(g.save),
            handler: save
        }];

        me.callParent(arguments);

        function save(){
            if(!me.isValid()) return ;
        }

        function reset(){
            me.reset();
        }
    }
});