Ext.define('LE.store.customers.AttrStore', {
    extend: 'Ext.data.Store',
    fields: ['id', 'descrip', 'attrtype', 'attrlist'],
    autoLoad: true,
    storeId: 'customerAttrStore',
    proxy: {
        url: 'rest/customer/getCustomerAttrTypes',
        type: 'rest',
        reader: {
            type: 'json'
        }
    }
});