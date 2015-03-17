Ext.define('LE.view.collateral.CollateralForm', {
    extend: 'Ext.form.Panel',
    margin: 5,
    bodyPadding: 5,
    width: 700,
    fieldDefaults: {
        labelWidth: 150,
        labelAlign: 'right',
        anchor: '100%'
    },
    constructor: function (cfg) {
        cfg = cfg || {};
        var me = this;



        me.callParent(arguments);
    }
});