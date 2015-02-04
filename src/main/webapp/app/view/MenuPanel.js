Ext.define('LE.view.MenuPanel', {
    extend: 'Ext.panel.Panel',
    border: false,
    //title: 'Menu',
    constructor: function (cfg) {
        var me = this;

        var menu = Ext.create('Ext.button.Segmented', {
            border: false,
            vertical: true,
            width: '100%',
            allowToggle: false,
            defaults: {
                height: 35,
                textAlign: 'left'
            },
            items: [{
                text: 'Clients',
                glyph: 'xf0c0@FontAwesome'
            }, {
                text: 'Loans',
                glyph: 'xf0d6@FontAwesome',
                menu: [{
                    glyph: 'xf09d@FontAwesome',
                    text: 'item 3'
                }, {
                    text: 'item 4'
                }]
            }, {
                glyph: 'xf09d@FontAwesome',
                text: 'item 5'
            }, {
                text: 'item 6'
            }]
        });
        x = menu;
        me.items = [ menu ];

        me.callParent(arguments);
    }
});