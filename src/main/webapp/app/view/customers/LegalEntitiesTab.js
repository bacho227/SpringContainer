Ext.define('LE.view.customers.LegalEntitiesTab', {
    extend: 'Ext.panel.Panel',
    title: 'იურიდიული',
    layout: 'hbox',
    border: false,
    bodyPadding: 15,
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
                fieldLabel: loc.customers.legalName,
                name: 'fullName'
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

        me.items = [ fieldset1 ];

        me.callParent(arguments);
    }
});