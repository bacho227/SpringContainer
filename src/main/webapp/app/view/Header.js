Ext.define('MI.view.Header', {
    extend: 'Ext.toolbar.Toolbar',
    controller: 'appController',
    bodyPadding: 5,
    constructor: function (cfg) {
        cfg = cfg || {};
        var me = this;

        var userBtn = Ext.create('MI.view.UserButton');

        me.items = [{
            xtype: 'label',
            html: '<strong>MISO - Admin</strong>'
        }, '->', userBtn];

        me.callParent(arguments);

        me.on('afterlayout', function () {
            me.setMaxHeight(me.getHeight());
        });
    }
});