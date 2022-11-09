import {useHistory} from "react-router-dom"
import InviteMembersForm from "../Workspace Components/InviteMembersForm";
import { useLocation } from 'react-router-dom';

function InviteMembersPage(){
    const history = useHistory();
    const location = useLocation();

    function InviteMembershandler(user){
        fetch(`http://localhost:8080/workspace/${location.state.data}`,{
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
            <InviteMembersForm InviteMembers={InviteMembershandler}/>
        </div>
    );
}

export default InviteMembersPage;
