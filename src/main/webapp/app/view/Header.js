Ext.define('LE.view.Header', {
    extend: 'Ext.toolbar.Toolbar',
    border: false,
    bodyPadding: 5,
    constructor: function (cfg) {
        var me = this;

        var themeCombo = Ext.create('Ext.form.field.ComboBox', {
            fieldLabel: 'თემა',
            name: 'theme',
            labelAlign: 'right',
            editable: false,
            value: localStorage.theme || 'neptune',
            store: ['aria', 'classic', 'crisp', 'crisp-touch', 'gray', 'neptune', 'neptune-touch'],
            listeners: {
                change: function(f, val){
                    localStorage.theme = val;
                    Ext.Msg.confirm("Warning", "Do you want to refresh web page?", function(ans){
                        if(ans == 'yes'){
                            location.reload();
                        }
                    });
                }
            }
        });

        me.items = [{
            xtype: 'label',
            html: '<strong>Loan Expert System</strong>'
        }, '->', themeCombo ];

        me.callParent(arguments);
    }
});