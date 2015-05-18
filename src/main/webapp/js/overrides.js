Ext.override(Ext.form.Panel, {
    constructor: function (cfg) {
        cfg = cfg || {};
        var me = this;

        me.callParent(arguments);

        if (me.submitFn || me.submitBtn) {
            me.addListener('afterrender', function () {
                me.keyNav = Ext.create('Ext.util.KeyNav', me.el, {
                    enter: function (e) {
                        if (me.getForm().isValid()) {
                            if (Ext.isFunction(me.submitFn)) {
                                me.submitFn.call();
                            } else if (me.submitBtn) {
                                me.submitBtn.fireHandler();
                            }
                        }
                    }
                });
            });
        }
    }
});