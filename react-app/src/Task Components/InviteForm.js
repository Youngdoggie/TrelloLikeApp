
import React, {useRef} from "react";

function InviteForm(props){
    const emailRef = useRef();

    function InviteMembershandler(event){
        event.preventDefault();

        const email = emailRef.current.value;
        const user = {email};
        props.InviteMembers(user);
    }

    return(
        <form on onSubmit={InviteMembershandler}>
            <label>Enter Assignees Email Address</label><br/><p></p>
            <input type={"email"} required placeholder="Email" ref ={emailRef}/>
            <p></p>
            <button id="invite-button">Submit</button>
        </form>
    );
}
export default InviteForm;