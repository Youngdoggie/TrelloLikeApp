import {useHistory} from "react-router-dom"
import { useLocation } from 'react-router-dom';
import InviteForm from "../Task Components/InviteForm";

function InvitePage(){
    const history = useHistory();
    const location = useLocation();

    function InviteMembershandler(user){
        fetch(`http://localhost:8080/task/${location.state.inviteTaskID}`,{
            method: 'PATCH',
            body: JSON.stringify(user),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(()=> history.replace('/workspace'));
    }


    return(
        <div class="text-center margin5">
            <h1>Invite members here</h1>
            <InviteForm InviteMembers={InviteMembershandler}/>
        </div>
    );
}

export default InvitePage;
