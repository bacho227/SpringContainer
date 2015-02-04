Ext.define('LE.view.MainPanel', {
    extend: 'Ext.panel.Panel',
    layout: 'border',
    title: 'Main Panel',
    constructor: function(cfg){
        var me = this;
        me.html = "body";
        me.callParent(arguments);
    }
});