Ext.define('LE.store.ParamStore', {
    extend: 'Ext.data.Store',
    storeId: 'paramStore',
    autoLoad: false,
    fields: ['id', 'descrip', 'long_description'],
    proxy: {
        url: 'rest/customer/getGenParamsByHeader',
        type: 'rest',
        reader: {
            type: 'json'
        }
    },
    setHeader: function(header){
        this.getProxy().extraParams = {
            header: header
        };
        this.load();
    }
});