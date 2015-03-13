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

        var individualsTab = Ext.create('LE.view.customers.IndividualsTab');
        var legalEntitiesTab = Ext.create('LE.view.customers.LegalEntitiesTab');

        var extraFieldset = Ext.create("LE.view.customers.ExtraFieldset");

        me.items = [{
            xtype: 'tabpanel',
            border: false,
            items: [ individualsTab, legalEntitiesTab ]
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