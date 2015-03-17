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

        me.text = le.user.firstName + ' ' + le.user.lastName;
        me.menu = [themeCombo, langCombo, {
            text: 'glyphs',
            handler: openGlyphs,
            glyph: g.get(g.gears)
        }, {
            xtype: 'menuseparator'
        }, {
            text: loc.logout,
            glyph: g.get(g.logout),
            handler: logout
        }];
        me.callParent(arguments);

        function openGlyphs(){
            btns = [];
            for(var i in g){
                if(typeof g[i] == 'string'){
                    var btn = Ext.create('Ext.button.Button', {
                        glyph: g.get(g[i]),
                        text: g[i] + ' - ' + i,
                        width: 140,
                        scale: 'large',
                        textAlign: 'left',
                        iconAlign: 'left'
                    });
                    btns.push(btn);
                }
            }
            Ext.create('Ext.window.Window', {
                autoShow: true,
                title:  'glyphs',
                bodyPadding: 5,
                width: 500,
                items: btns
            });
        }
    }
});