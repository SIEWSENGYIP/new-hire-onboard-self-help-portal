import {Entity, PrimaryGeneratedColumn, ManyToOne, JoinColumn} from "typeorm";
import { Todo } from "./Todo";
import { Team } from "./Team";

@Entity({name: "team_todos"})
export class TeamTodo {

    @PrimaryGeneratedColumn()
    id: number;

    @ManyToOne(type => Todo, todo => todo.teamTodos)
    @JoinColumn({name: "todo_id"})
    todo: Todo

    @ManyToOne(type => Team, team => team.teamTodos)
    @JoinColumn({name: "team_id"})
    team: Team

}