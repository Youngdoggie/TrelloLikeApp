import React, {useRef} from "react";
import {Link} from "react-router-dom";
import {Button} from "@mui/material";

function ForgotPasswordForm(props){
    const emailRef = useRef();
    const answerRef = useRef();
    const newPasswordRef = useRef();

    function ForgotPasswordhandler(event){
        event.preventDefault();

        const email = emailRef.current.value;
        const answer = answerRef.current.value;
        const password = newPasswordRef.current.value;
        const user = {email, answer,password};
        props.ForgotPassword(user);
    }

    return(
        <div class="text-center margin5">
            <form on onSubmit={ForgotPasswordhandler}>
                <label>Enter your Email Address</label><br/>
                <input type={"email"} required placeholder="Email" ref ={emailRef}/>
                <p></p>
                <label>Security Question: What is your favorite color?</label><br/>
                <input type={"text"} required placeholder="your security answer"ref={answerRef}/>
                <p></p>
                <label>Enter your New Password</label><br/>
                <input type={"text"} required placeholder="password"ref={newPasswordRef}/>
                <p></p>
                <button id="reg-button">
                    <Link to='/login' style={{textDecoration: 'none', color:'white'}}>
                        Reset Your Password
                    </Link>
                </button>
            </form>
        </div>
    );
}

export default ForgotPasswordForm;
