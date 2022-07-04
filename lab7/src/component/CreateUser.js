import React, {useState} from "react";

export  default function CreateUser(){
     const initialState={name:'test',email:'test@gmail.com', password:'password'}
     const[saveUserState,setUserState]=useState(initialState);

     const fieldChanged = (event)=> {
         const copyState ={...saveUserState};
         copyState[event.target.name]= event.target.value;
         setUserState(copyState);
     }
     const onClicked=()=>{
          console.log(saveUserState)
     }

     return (
         <div>
             Name: <input
             type='text'
             defaultValue={saveUserState.name}
             name='name'
             onChange={(event) => { fieldChanged(event) }}
         />
              <br />

              Email: <input
             type='text'
             name="email"
             defaultValue={saveUserState.email}
             onChange={(event) => { fieldChanged(event) }}
         />

              <br />

              Password: <input
             type='password'
             name="password"
             defaultValue={saveUserState.password}
             onChange={(event) => { fieldChanged(event) }}
         />

              <br />

              <input
                  type='button'
                  value='Save'
                  onClick={onClicked}
              />
         </div>
     )

}