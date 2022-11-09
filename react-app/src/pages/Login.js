import LoginForm from "../Components/LoginForm";
import {useHistory} from "react-router-dom"
import React, { useEffect, useState } from 'react';

function LoginPage(){
    const history = useHistory();
    function loginUserHandler(user){
        fetch('http://localhost:8080/user/login',{
           method: 'POST',
           body: JSON.stringify(user),
           headers: {
                'Content-Type': 'application/json'
           }
        }).then(response => response.json())
        .then(ID =>{
            localStorage.setItem("userID", ID);
            if(ID !== -1){
                history.replace('/home');
            }
        })
    };

    return(
        <div class="text-center margin5">
            <h1>Login here</h1>
            <LoginForm loginUser = {loginUserHandler}/>
        </div>
    );
}

export default LoginPage;
