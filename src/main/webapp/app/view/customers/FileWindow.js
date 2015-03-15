Ext.define('LE.view.customers.FileWindow', {
    extend: 'Ext.window.Window',
    width: '80%',
    height: '80%',
    autoShow: true,
    modal: true,
    layout: 'anchor',
    autoScroll: true,
    maximizable: true,
    title: loc.customers.file,
    constructor: function (cfg) {
        cfg = cfg || {};
        var me = this;

        var form = Ext.create('Ext.form.Panel', {
            bodyPadding: 5,
            border: false,
            items: [{
                xtype: 'filefield',
                buttonText: loc.customers.upload,
                width: 500,
                listeners: {
                    change: upload
                }
            }]
        });

        var fileViewPanel = Ext.create('Ext.panel.Panel', {
            border: false,
            items: [{
                xtype: 'component',
                autoEl: {
                    tag: 'iframe',
                    cls: 'customer-file-view',
                    style: 'border: 0; width: 100%',
                    src: ''
                }
            }]
        });

        me.items = [ form, fileViewPanel ];

        me.callParent(arguments);

        function upload(){
            log('upload')
            Ext.query('iframe.customer-file-view')[0].src = 'images/softgen-logo.png'
        }
    }
});