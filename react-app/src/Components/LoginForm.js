import React, {useRef} from "react";
import {Link} from "react-router-dom";
import {Button} from "@mui/material";
import {useNavigate} from 'react-router-dom'

function LoginForm(props){
    const emailRef = useRef();
    const passwordRef = useRef();

    function loginUserhandler(event){
        event.preventDefault();
        
        const email = emailRef.current.value;
        const password = passwordRef.current.value;
        const user = {email, password};
        props.loginUser(user);
    }

    return(
        <div class="text-center margin5">
            <form on onSubmit={loginUserhandler}>
                <label>Email Address</label><br/>
                <input type={"email"} required placeholder="Email" ref ={emailRef}/>
                <p></p>
                <label>Password</label><br/>
                <input type={"password"} required placeholder="Password"ref={passwordRef}/>
                <p></p>
                <button id="login-button">Login</button>
                <p></p>
                <Button variant="h6" component="div" sx={{padding: '0 8px'}}>
                    <Link to='/ForgotPassword' style={{textDecoration: 'none', color:'#0a8df2'}}>
                        Forgot Password?
                    </Link>
                </Button>
            </form>
        </div>
    );
}

export default LoginForm;
