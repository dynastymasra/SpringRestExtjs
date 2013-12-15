/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

Ext.define('SpringExtJS.model.Mahasiswa', {
    extend: 'SpringExtJS.model.Base',
    fields: [
        {
            name: 'id',
            type: 'int'
        },
        {
            name: 'nim',
            type: 'string'
        },
        {
            name: 'name',
            type: 'string'
        },
        {
            name: 'email',
            type: 'string'
        },
        {
            name: 'phone',
            type: 'string'
        },
        {
            name: 'gender',
            type: 'string'
        },
        {
            name: 'date',
            type: 'date'
        }

    ]
});