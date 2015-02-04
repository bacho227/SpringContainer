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
                text: loc.clients,
                glyph: g.get(g.clients)
            }, {
                text: loc.loans,
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
        x = menu;
        me.items = [ menu ];

        me.callParent(arguments);
    }
});