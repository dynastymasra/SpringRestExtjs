Ext.define('SpringExtJS.model.Base', {
    extend: 'Ext.data.Model',
    fields: [
        {
            name: 'createdBy',
            type: 'string'
        },
        {
            name: 'updatedBy',
            type: 'string'
        },
        {
            name: 'createdAt',
            type: 'date'
        },
        {
            name: 'updatedAt',
            type: 'date'
        },
        {
            name: 'entity',
            type: 'string'
        }
    ]
});