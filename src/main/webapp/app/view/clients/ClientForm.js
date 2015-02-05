Ext.define('LE.view.clients.ClientForm', {
    extend: 'Ext.form.Panel',
    bodyPadding: 5,
    width: 400,
    frame: true,
    title: loc.clients.addClient,
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
                { id: 1, name: 'ფიზიკური პირი'},
                { id: 2, name: 'იურიდიული პირი'}
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

        me.items = [{
            xtype: 'fieldset',
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
                fieldLabel: loc.clients.personalNo,
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
            }, {
                fieldLabel: loc.clients.firstName,
                name: 'firstName',
                vtype: 'name'
            }, {
                fieldLabel: loc.clients.lastName,
                name: 'lastName',
                vtype: 'name'
            }, {
                xtype: 'datefield',
                fieldLabel: loc.clients.birthDate,
                name: 'birthDate',
                vtype: 'birthdate'
            }]
        }, {
            xtype: 'fieldset',
            collapsible: true,
            title: loc.extraParams,
            collapsed: true,
            defaults: {
                xtype: 'textfield'
            },
            items: [{
                fieldLabel: loc.clients.legalName,
                name: 'legalName'
            }, {
                fieldLabel: loc.clients.financialSector,
                name: 'financialSector'
            }, {
                fieldLabel: loc.clients.address,
                name: 'address'
            }, {
                fieldLabel: loc.clients.legalAddress,
                name: 'legalAddress'
            }, {
                fieldLabel: loc.clients.docType,
                name: 'docType'
            }, {
                fieldLabel: loc.clients.docNo,
                name: 'docNo'
            }, {
                fieldLabel: loc.clients.docIssuer,
                name: 'docIssuer'
            }, {
                xtype: 'datefield',
                fieldLabel: loc.clients.docIssueDate,
                name: 'docIssueDate'
            }, {
                xtype: 'datefield',
                fieldLabel: loc.clients.docValidDate,
                name: 'docValidDate'
            }, {
                fieldLabel: loc.clients.phone,
                name: 'phone',
                vtype: 'phone'
            }, {
                fieldLabel: loc.clients.mobile,
                name: 'mobile',
                vtype: 'mobile'
            }, {
                fieldLabel: loc.clients.email,
                name: 'email',
                vtype: 'email'
            }, {
                xtype: 'textareafield',
                fieldLabel: loc.note,
                name: 'note'
            }, {
                xtype: 'filefield',
                fieldLabel: loc.clients.photo,
                name: 'photo'
            }]
        }]

        me.callParent(arguments);
    }
});