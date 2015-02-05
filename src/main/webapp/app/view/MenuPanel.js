Ext.define('LE.view.MenuPanel', {
    extend: 'Ext.panel.Panel',
    border: false,
    //title: 'Menu',
    constructor: function (cfg) {
        cfg = cfg || {};
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
                text: loc.menu.clients,
                glyph: g.get(g.clients)
            }, {
                text: loc.menu.loans,
                glyph: g.get(g.loans),
                menu: [{
                    glyph: g.get(g.card),
                    text: 'item 3'
                }, {
                    text: 'item 4'
                }]
            }, {
                glyph: g.get(g.card),
                text: 'item 5'
            }, {
                text: 'item 6'
            }]
        });

        me.items = [ menu ];

        me.callParent(arguments);
    }
});