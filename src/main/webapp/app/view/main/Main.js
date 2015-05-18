Ext.define('MI.view.main.Main', {
    extend: 'Ext.panel.Panel',
    border: false,
    bodyPadding: 5,
    constructor: function (cfg) {
        cfg = cfg || {};
        var me = this;

        me.html = me.title;

        me.callParent(arguments);
    }
});