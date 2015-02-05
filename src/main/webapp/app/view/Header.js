Ext.define('LE.view.Header', {
    extend: 'Ext.toolbar.Toolbar',
    border: false,
    bodyPadding: 5,
    constructor: function (cfg) {
        cfg = cfg || {};
        var me = this;

        var userBtn = Ext.create('LE.view.UserButton');

        me.items = [ {
            xtype: 'label',
            html: '<strong>Loan Expert System</strong>'
        }, '->', userBtn];

        me.callParent(arguments);
    }
});