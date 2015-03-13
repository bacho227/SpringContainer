Ext.define('LE.view.customers.ExtraFieldset', {
    extend: 'Ext.form.FieldSet',
    collapsible: true,
    collapsed: true,
    layout: 'hbox',
    title: loc.extraParams,
    margin: 5,
    constructor: function (cfg) {
        cfg = cfg || {};
        var me = this;

        var finSectorStore = Ext.create('Ext.data.Store', {
            fields: ['id', 'name'],
            data: [
                { id: 1, name: 'სოფლის მეურნეობა'},
                { id: 2, name: 'ბიზნესი'}
            ]
        });

        var fieldset1 = Ext.create('Ext.form.FieldSet', {
            border: false,
            defaults: {
                xtype: 'textfield'
            },
            items: [{
                xtype: 'checkbox',
                fieldLabel: loc.type,
                boxLabel: loc.customers.isResident,
                name: 'isResident'
            }, {
                xtype: 'combo',
                fieldLabel: loc.customers.financialSector,
                name: 'financialSector',
                displayField: 'name',
                valueField: 'id',
                queryMode: 'local',
                editable: false,
                store: finSectorStore
            }, {
                fieldLabel: loc.customers.address,
                name: 'address'
            }, {
                fieldLabel: loc.customers.legalAddress,
                name: 'legalAddress'
            }, {
                fieldLabel: loc.customers.docType,
                name: 'docType'
            }, {
                fieldLabel: loc.customers.docNo,
                name: 'docNo'
            }, {
                fieldLabel: loc.customers.docIssuer,
                name: 'docIssuer'
            }]
        });

        var fieldset2 = Ext.create('Ext.form.FieldSet', {
            border: false,
            defaults: {
                xtype: 'textfield'
            },
            items: [ {
                xtype: 'datefield',
                fieldLabel: loc.customers.docIssueDate,
                name: 'docIssueDate'
            }, {
                xtype: 'datefield',
                fieldLabel: loc.customers.docValidDate,
                name: 'docValidDate'
            }, {
                fieldLabel: loc.customers.phone,
                name: 'phone',
                vtype: 'phone'
            }, {
                fieldLabel: loc.customers.mobile,
                name: 'mobile',
                vtype: 'mobile'
            }, {
                fieldLabel: loc.customers.email,
                name: 'email',
                vtype: 'email'
            }, {
                xtype: 'textareafield',
                fieldLabel: loc.note,
                name: 'note'
            }, {
                xtype: 'filefield',
                fieldLabel: loc.customers.photo,
                name: 'photo'
            }]
        });

        me.items = [fieldset1, fieldset2];

        me.callParent(arguments);
    }
});