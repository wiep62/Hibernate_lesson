package first;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id //без него не работает гибернейт
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //говорим хибернейту как наз. колонка в таблице
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "score")
    private int score;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
