override('Ext.form.field.Text');
override('Ext.form.field.ComboBox');
override('Ext.form.field.TextArea');

setTimeout(function(){
    setVTypes();
}, 1000);

function override(className) {
    Ext.define(className, {
        override : className,
        constructor : function(cfg) {
            cfg = cfg || {};
            var me = this;
            var isEng = cfg.isEng || me.isEng;
            var autoFocus = cfg.autoFocus || me.autoFocus;
            me.callParent(arguments);

            me.on({
                focus : function() {
                    if(window.geokb) geokb.toggle(!isEng);
                }
            });
            if(autoFocus){
                me.on('afterrender', function(f){
                    setTimeout(function(){
                        f.focus();
                    }, 300);
                });
            }

        }
    });
}

Ext.define('Ext.window.Window', {
    override: 'Ext.window.Window',
    constrain: true
});

Ext.define('Ext.form.Panel', {
    override : 'Ext.form.Panel',
    constructor : function(cfg) {
        cfg = cfg || {};
        var me = this;

        var fn = cfg.submitFn || me.submitFn;

        me.callParent(arguments);

        if (typeof fn === 'function') {
            me.addListener('afterrender', function() {
                me.keyNav = Ext.create('Ext.util.KeyNav', me.el, {
                    enter : function(e) {
                        if (me.getForm().isValid()) fn();
                    }
                });
            });
        }
    }
});

Ext.define('Ext.grid.Panel', {
    override : 'Ext.grid.Panel',
    constructor : function(cfg) {
        cfg = cfg || {};
        var me = this;
        var countLabel = null;

        if (cfg.footer || me.footer) {
            countLabel = Ext.create('Ext.form.Label');

            me.bbar = [ {
                xtype : 'label',
                html : 'სულ: '
            }, countLabel ];
        }

        me.callParent(arguments);

        if (cfg.footer || me.footer) {
            me.getStore().on('datachanged', function() {
                var count = Math.max(me.getStore().getTotalCount(), me.getStore().getCount());
                countLabel.update(count.toString());
            });
        }
    }
});

function setVTypes() {
    Ext.apply(Ext.form.field.VTypes, {
        birthdate: function (val, field) {
            var date = field.parseDate(val);
            if (!date) return true;
            var y = date.getFullYear(); // TODO შესამოწმებელია სხვა ბრაუზერებში
            var Y = new Date().getFullYear();
            if (y > Y - 5) return false;
            return true;
        },
        birthdateText: loc.invalidYear,

        personalno: function (val, field) {
            var regex = /^[\d]{11}$/;
            return regex.test(val);
        },
        personalnoText: loc.invalidPersonalNo,

        phone: function (val, field) {
            var regex = /^[\d]{7}$/;
            return regex.test(val);
        },
        phoneText: loc.invalidPhone,

        mobile: function (val, field) {
            var regex = /^(5)[\d]{8}$/;
            return regex.test(val);
        },
        mobileText: loc.invalidMobile,

        name: function(val, field){
            var regex = /^[a-zA-Zა-ჰ]+$/;
            return regex.test(val);
        },
        nameText: loc.invalidName
    });
}

