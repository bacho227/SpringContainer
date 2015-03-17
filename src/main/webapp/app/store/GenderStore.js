Ext.define('LE.store.GenderStore', {
    extend: 'Ext.data.Store',
    storeId: 'genderStore',
    fields: ['id', 'name'],
    data: [
        {id: 1, name: 'მამრობითი'},
        {id: 2, name: 'მდედრობითი'}
    ]
});