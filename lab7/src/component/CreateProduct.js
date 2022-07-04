import React,{useState} from "react";

export default function CreateProduct(){
    const initialState ={id:'1',name:'Book',price:'123'}
    const [saveProductState,setProductState]=useState(initialState)

    const fieldChanged = (event)=> {
        const copyState ={...saveProductState};
        copyState[event.target.name]= event.target.value;
        setProductState(copyState);
    }
    const onClicked=()=>{
        console.log(saveProductState)
    }
    return(
        <div>
            Id:<input type='text'
                      defaultValue={saveProductState.id}
                      name='id'
                      onChange={(event) => { fieldChanged(event) }}
        />
            <br/>
            Name:<input type='text'
                        defaultValue={saveProductState.name}
                        name ='role'
                        onChange={(evet)=>{fieldChanged(evet)}}
        />
            <br/>
            Price:<input type='text'
                        defaultValue={saveProductState.price}
                        name ='role'
                        onChange={(evet)=>{fieldChanged(evet)}}
        />
            <br/>
            <input
                type='button'
                value='Save'
                onClick={onClicked}
            />
        </div>
    )
}