package sinuca.example.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;

@Repository
public class SinucaRepository {
    
    private final JdbcTemplate jdbc;

    public SinucaRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    //Jogador
    //Busca id do jogador pelo nome; se não existir, insere.
    public long buscarOuCriarJogador(String nome) {
        try {
            return jdbc.queryForObject(
                "SELECT id_jogador FROM jogador WHERE nome = ?",
                Long.class,
                nome
            );
        } catch (EmptyResultDataAccessException e) {
            return jdbc.queryForObject(
                "INSERT INTO jogador (nome) VALUES (?) RETURNING id_jogador",
                Long.class,
                nome
            );
        }
    }

    public void salvarParticipacao(Long idPartida, Long idJogador, double valorpago) {
        jdbc.update(
            "INSERT INTO jogador_partida (id_partida, id_jogador, valor_pago) VALUES (?, ?, ?)",
            idPartida, idJogador, valorpago
        );
    }

    public Long salvarPartida(String nome) {
        return jdbc.queryForObject(
            "INSERT INTO partida (nome) VALUES (?) RETURNING id_partida",
            Long.class,
            nome
        );
    }
}
