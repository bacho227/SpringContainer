Ext.define('LE.view.Header', {
    extend: 'Ext.toolbar.Toolbar',
    border: false,
    bodyPadding: 5,
    constructor: function (cfg) {
        var me = this;

        var ka = Ext.create('Ext.button.Button', {
            text: 'KA',
            pressed: (lang == 'ka'),
            handler: function(){
                changeLang('ka');
            }
        });

        var en = Ext.create('Ext.button.Button', {
            text: 'EN',
            pressed: (lang == 'en'),
            handler: function(){
                changeLang('en');
            }
        });

        var themeCombo = Ext.create('Ext.form.field.ComboBox', {
            fieldLabel: loc.theme,
            name: 'theme',
            labelWidth: 50,
            labelAlign: 'right',
            editable: false,
            width: 180,
            value: localStorage.theme || 'neptune',
            store: ['aria', 'classic', 'crisp', 'crisp-touch', 'gray', 'neptune', 'neptune-touch'],
            listeners: {
                change: function(f, val){
                    changeTheme(val);
                }
            }
        });

        me.items = [ {
            xtype: 'label',
            html: '<strong>Loan Expert System</strong>'
        }, '->', ka, en, '-', themeCombo ];

        me.callParent(arguments);
    }
});