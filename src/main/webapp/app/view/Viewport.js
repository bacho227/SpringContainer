Ext.define('MI.view.Viewport', {
    extend: 'Ext.container.Viewport',
    layout: 'border',
    border: false,
    defaults: {
        split: true
    },
    constructor: function (cfg) {
        cfg = cfg || {};
        var me = this;

        var header = Ext.create('MI.view.Header', {
            region: 'north'
        });

        var mainTabPanel = Ext.create('Ext.tab.Panel', {
            region: 'center',
            bodyPadding: 5,
            autoScroll: true
        });

        var menu = Ext.create('MI.view.Menu', {
            region: 'west',
            mainTabPanel: mainTabPanel
        });

        me.items = [header, menu, mainTabPanel];

        me.callParent(arguments);
    }
});