import React from "react";
import {Route, Switch} from "react-router-dom";
import RegisterPage from "./pages/Register";
import HomePage from "./pages/Homepage";
import LoginPage from "./pages/Login";
import ForgotPasswordPage from "./pages/ForgotPassword";
import Navigation from "./Components/Navigation";
import WorkspacePage from "./Workspace Pages/Workspace";
import CreateworkspacePage from "./Workspace Pages/Createworkspace";
import InviteMembersPage from "./Workspace Pages/InviteMembers";
import EditWorkspacePage from "./Workspace Pages/EditWorkspace";
import CreateBoardPage from "./Board/CreateBoard";
import Boards from "./Board/Board";
import TaskPage from "./Task/Tasks"
import CreateTaskPage from "./Task/Createtasks";
import ChangeStatusPage from "./Task/ChangeStatus";
import InvitePage from "./Task/Invite";
import SearchPage from "./Task/Search";
import DueInWeekPage from "./Task/DueInWeek";
import DueToday from "./Task/dueToday";
import OverDue from "./Task/OverDue";

function App() {
  return (
      <div>
        <Navigation/>
        <Switch>
          <Route path="/register">
            <RegisterPage/>
          </Route>
          <Route path='/login'>
            <LoginPage/>
          </Route>
          <Route path='/home'>
            <HomePage/>
          </Route>
          <Route path="/ForgotPassword">
            <ForgotPasswordPage/>
          </Route>
          <Route path='/Createworkspace'>
            <CreateworkspacePage />
          </Route>
          <Route path='/invite'>
            <InviteMembersPage />
          </Route>
          <Route path='/workspace'>
             <WorkspacePage />
          </Route>
          <Route path='/board'>
             <Boards/>
          </Route>
          <Route path='/createboard'>
             <CreateBoardPage/>
          </Route>
          <Route path='/editworkspace'>
             <EditWorkspacePage/>
          </Route>
          <Route path='/tasks'>
              <TaskPage/>
          </Route>
          <Route path='/createTasks'>
              <CreateTaskPage/>
          </Route>
          <Route path='/changeStatus'>
              <ChangeStatusPage/>
          </Route>
          <Route path='/inviteMember'>
              <InvitePage/>
          </Route>
          <Route path='/search'>
              <SearchPage/>
          </Route>
          <Route path='/dueInWeek'>
              <DueInWeekPage/>
          </Route>
          <Route path='/dueToday'>
              <DueToday/>
          </Route>
          <Route path='/overDue'>
              <OverDue/>
          </Route>
        </Switch>
      </div>
  );
}

export default App;
