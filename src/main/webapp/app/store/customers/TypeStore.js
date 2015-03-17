Ext.define('LE.store.customers.TypeStore', {
    extend: 'Ext.data.Store',
    fields: ['id', 'descrip'],
    data: [
        {id: 1, descrip: 'ტიპი1'},
        {id: 2, descrip: 'ტიპი2'},
        {id: 3, descrip: 'ტიპი3'}
    ]
});