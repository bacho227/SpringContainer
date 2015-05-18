Ext.define('MI.view.UserButton', {
    extend: 'Ext.button.Split',
    glyph: glyphs.get(glyphs.user),
    text: MI.user.firstName + ' ' + MI.user.lastName,
    constructor: function (cfg) {
        cfg = cfg || {};
        var me = this;

        var themeCombo = Ext.create('Ext.form.field.ComboBox', {
            fieldLabel: 'თემა',
            name: 'theme',
            labelWidth: 80,
            editable: false,
            width: 200,
            glyph: glyphs.get(glyphs.brush),
            value: localStorage.theme || 'gray',
            store: ['aria', 'classic', 'crisp', 'crisp-touch', 'gray', 'neptune', 'neptune-touch'],
            listeners: {
                change: 'changeTheme'
            }
        });

        me.menu = [themeCombo, {
            text: 'glyphs',
            handler: openGlyphs,
            glyph: glyphs.get(glyphs.gears)
        }, {
            xtype: 'menuseparator'
        }, {
            text: 'გამოსვლა',
            glyph: glyphs.get(glyphs.logout),
            href: '/rest/security/signOut'
        }];

        me.callParent(arguments);

        function openGlyphs() {
            btns = [];
            for (var i in glyphs) {
                if (typeof glyphs[i] == 'string') {
                    var btn = Ext.create('Ext.button.Button', {
                        glyph: glyphs.get(glyphs[i]),
                        text: glyphs[i] + ' - ' + i,
                        width: 160,
                        scale: 'large',
                        textAlign: 'left',
                        iconAlign: 'left'
                    });
                    btns.push(btn);
                }
            }
            Ext.create('Ext.window.Window', {
                autoShow: true,
                title: 'glyphs',
                bodyPadding: 5,
                width: 700,
                items: btns
            });
        }
    }
})
;