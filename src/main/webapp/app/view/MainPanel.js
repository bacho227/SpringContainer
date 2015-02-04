Ext.define('LE.view.MainPanel', {
    extend: 'Ext.panel.Panel',
    layout: 'border',
    border: false,
    defaults: {
        split: true
    },
    constructor: function(cfg){
        var me = this;

        var header = Ext.create('LE.view.Header', {
            region: 'north'
        });

        var menu = Ext.create('LE.view.MenuPanel', {
            region: 'west',
            bodyPadding: 2,
            width: 180
        });

        var center = Ext.create('Ext.panel.Panel', {
            region: 'center'
        });

        me.items = [ header, menu, center ];

        me.callParent(arguments);
    }
});