Ext.define('LE.view.customers.AttributesFieldset', {
    extend: 'Ext.form.FieldSet',
    layout: 'anchor',
    width: 350,
    bodyPadding: 5,
    title: loc.attributes,
    collapsible: true,
    collapsed: true,
    margin: 5,
    fieldDefaults: {
        anchor: '100%',
        labelAlign: 'right',
        labelWidth: 130
    },
    constructor: function (cfg) {
        cfg = cfg || {};
        var me = this;

        var attrStore = Ext.StoreManager.lookup('customerAttrStore') ||
            Ext.create('LE.store.customers.AttrStore');


        me.callParent(arguments);

        attrStore.on('load', function(){
            attrStore.each(function(rec){
                var field = createField(rec);
                me.add(field);
            });
        });

        function createField(rec){
            var type = rec.get('attrtype');
            var field;
            var opt = {
                attrId: rec.get('id'),
                name: 'attributes',
                fieldLabel: rec.get('descrip'),
                anchor: '100%'
            };
            switch(type){
                case 0:
                    field = Ext.create('Ext.form.field.Number', opt);
                    break;
                case 1:
                    field = Ext.create('Ext.form.field.Number', opt);
                    break;
                case 3:
                    field = Ext.create('Ext.form.field.Date', opt);
                    break;
                case 4:
                    var store = Ext.create('LE.store.ParamStore');
                    store.setHeader({
                        header: rec.get('attrlist')
                    });
                    opt.editable = false;
                    opt.queryMode = 'local';
                    opt.displayField = 'descrip';
                    opt.valueField = 'id';
                    opt.store = store;
                    field = Ext.create('Ext.form.field.ComboBox', opt);
                    break;
                default:
                    field = Ext.create('Ext.form.field.Text', opt);
                    break;
            }
            return field;
        }
        me.getValues = function(){
            var data = [];
            var fields = me.items.items;
            for(var i in fields){
                var obj = {
                    attrTypeId: fields[i].attrId,
                    value: fields[i].getValue()
                };
                if(fields[i].xtype == 'datefield'){
                    obj.value = obj.value ? obj.value.getTime() : null;
                }
                data.push(obj);
            }
            return data;
        }
    }
});