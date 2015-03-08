Ext.define('LE.view.UserButton', {
    extend: 'Ext.button.Split',
    constructor: function (cfg) {
        cfg = cfg || {};
        var me = this;

        var langStore = Ext.create('Ext.data.Store', {
            fields: ['id', 'name'],
            data: [
                {id: 'ka', name: 'ქართული'},
                {id: 'en', name: 'English'}
            ]
        });

        var langCombo = Ext.create('Ext.form.field.ComboBox', {
            fieldLabel: loc.language,
            name: 'language',
            labelWidth: 80,
            //labelAlign: 'right',
            editable: false,
            width: 200,
            value: localStorage.lang || 'ka',
            store: langStore,
            queryMode: 'local',
            displayField: 'name',
            valueField: 'id',
            listeners: {
                change: function(f, val){
                    changeLang(val);
                }
            }
        });

        var themeCombo = Ext.create('Ext.form.field.ComboBox', {
            fieldLabel: loc.theme,
            name: 'theme',
            labelWidth: 80,
            //labelAlign: 'right',
            editable: false,
            width: 200,
            glyph: g.get(g.brush),
            value: localStorage.theme || 'neptune',
            store: ['aria', 'classic', 'crisp', 'crisp-touch', 'gray', 'neptune', 'neptune-touch'],
            listeners: {
                change: function(f, val){
                    changeTheme(val);
                }
            }
        });

        me.glyph = g.get(g.user);

        me.text = le.user.name + ' ' + le.user.surname;
        me.menu = [themeCombo, langCombo, {
            xtype: 'menuseparator'
        }, {
            text: loc.logout,
            glyph: g.get(g.logout),
            handler: logout
        }];
        me.callParent(arguments);
    }
});