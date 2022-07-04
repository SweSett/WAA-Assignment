import React from 'react';
function ProductList() {
    const Product = [
        {id:'1', name: 'Apple',price:'12'},
        {id:'2', name: 'Apricot', price:'10'},
        {id:'3', name: 'Honeyberry',price:'20' },
        {id:'4', name: 'Papaya',price:'15' },
        {id:'5', name: 'Jambul',price:'12' },
        {id:'6', name: 'Plum',price:'32' },
        {id:'7', name: 'Lemon',price:'5' },
        {id:'8', name: 'Pomelo',price:'16' }
    ];
    return (
        <div>
            {Product.map(data => (
                <p>Id: {data.id} Name :{data.name} Price :{data.price} </p>
            ))}
        </div>
    );
}
export default ProductList;