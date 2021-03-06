package info.eventium.eventium;

import core.entity.Source;
import core.repository.SourceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SourceRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SourceRepository sourceRepository;

    @Test
    public void findSourceByName() {

        Source source = new Source();
        source.setName("twitter");
        entityManager.persist(source);
        entityManager.flush();

        Source found = sourceRepository.findByName("twitter").get();
        assertThat(found).isNotNull();
    }
}
