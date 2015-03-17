Ext.define('LE.view.customers.FileWindow', {
    extend: 'Ext.window.Window',
    width: '80%',
    height: '80%',
    autoShow: true,
    modal: true,
    layout: 'fit',
    autoScroll: true,
    //maximizable: true,
    title: loc.customers.file,
    onEsc: function(){ this.hide(); },
    constructor: function (cfg) {
        cfg = cfg || {};
        var me = this;

        var fileView = Ext.create('Ext.Component', {
            autoEl: {
                tag: 'iframe',
                cls: 'customer-file-view',
                src: ''
            }
        });

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
            }, fileView]
        });



        me.items = [ form ];

        me.buttons = [{
            text: 'Ok',
            glyph: g.get(g.check),
            handler: function(){
                setPhoto("photoid");
            }
        }, {
            text: 'გაუქმება',
            glyph: g.get(g.close),
            handler: function(){
                setPhoto();
            }
        }];

        me.callParent(arguments);

        function upload(){
            log('upload');
            setIframeSrc('images/softgen-logo.png');


        }
        function setPhoto(photoId){
            if(!photoId){
                setIframeSrc();
                form.reset();
            }
            cfg.customerForm.getForm().setValues({photo: photoId || ''});
            me.hide();
        }
        function setIframeSrc(src){
            Ext.query('iframe.customer-file-view')[0].src = src || '';
        }
    }
});