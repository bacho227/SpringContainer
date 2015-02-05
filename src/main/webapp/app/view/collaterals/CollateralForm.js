Ext.define('LE.view.collaterals.CollateralForm', {
    extend: 'Ext.form.Panel',
    frame: true,
    title: loc.collaterals.addCollateral,
    constructor: function (cfg) {
        cfg = cfg || {};
        var me = this;



        me.callParent(arguments);
    }
});