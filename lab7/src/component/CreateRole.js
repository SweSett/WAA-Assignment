import React,{useState} from "react";

export default function CreateRole(){

    const initialState ={id:'1',role:'Admin'}
    const [saveRoleState,setRoletState]=useState(initialState)

    const fieldChanged = (event)=> {
        const copyState ={...saveRoleState};
        copyState[event.target.name]= event.target.value;
        setRoletState(copyState);
    }
    const onClicked=()=>{
        console.log(saveRoleState)
    }
   return(
       <div>
           Id:<input type='text'
                     defaultValue={saveRoleState.id}
                     name='id'
                     onChange={(event) => { fieldChanged(event) }}
       />
           <br/>
           Role:<input type='text'
                       defaultValue={saveRoleState.role}
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