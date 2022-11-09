import React, {useRef} from "react";

function RegisterForm(props){
    const emailRef = useRef();
    const passwordRef = useRef();
    const answerRef = useRef();

    function registerUserHandler(event){
        event.preventDefault();
        const email = emailRef.current.value;
        const password = passwordRef.current.value;
        const answer = answerRef.current.value;
        const user = {email, password, answer};
        props.registerUser(user);
    }

    return(
        <div class="text-center margin5">
            <form onSubmit={registerUserHandler}>
                <label>Enter your Email Address</label><br/>
                <input type={"email"} required placeholder="Email" ref ={emailRef}/>
                <p></p>
                <label>Enter your Password</label><br/>
                <input type={"password"} required placeholder="Password"ref={passwordRef}/>
                <p></p>
                <label>Security Question: What is your favorite color?</label><br/>
                <input type={"text"} required placeholder="Answer" ref={answerRef}/>
                <p></p>
                <button id="reg-button">Register</button>
            </form>
        </div>
    );

}

export default RegisterForm;
