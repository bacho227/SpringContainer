Ext.define('MI.view.Menu', {
    extend: 'Ext.panel.Panel',
    controller: 'appController',
    bodyPadding: 1,
    width: 180,
    maxWidth: 300,
    listeners: {
        afterrender: 'loadMainItem'
    },
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
                text: 'Main',
                mainItemClass: 'MI.view.main.Main',
                handler: 'menuItemClicked',
                defaultItem: true
            }, {
                text: 'Test Item 1',
                mainItemClass: 'MI.view.main.Main',
                handler: 'menuItemClicked'
            }, {
                text: 'Test Item 2',
                mainItemClass: 'MI.view.main.Main',
                handler: 'menuItemClicked'
            }, {
                text: 'Test Item 3',
                mainItemClass: 'MI.view.main.Main',
                handler: 'menuItemClicked'
            }]
        });

        me.items = [menu];

        me.getMainTabPanel = function () {
            return cfg.mainTabPanel;
        };
        me.getMenu = function () {
            return menu;
        };
        me.callParent(arguments);

    }
});