package Devopshtml.business;

import Devopshtml.db.BookmarkDAO;
import Devopshtml.domain.Bookmark;
import org.demoiselle.stereotype.BusinessController;
import org.demoiselle.template.DatabaseDelegator;

import javax.transaction.Transactional;
import java.util.List;

/**
 * <p>Contains business logic to persist and maintain bookmarks.</p>
 *
 * @author SERPRO
 */
@BusinessController
public class BookmarkBC extends DatabaseDelegator<Bookmark, Long, BookmarkDAO> {

	private static final long serialVersionUID = 679187426644841581L;

	/**
	 * Do initial importing of persisted data into the database.
	 *
	 * @see ApplicationStartup
	 */
	@Transactional
	public void importData() {
		if (listAll().isEmpty()) {
			persist(new Bookmark("Demoiselle Portal", "http://www.frameworkdemoiselle.gov.br"));
			persist(new Bookmark("Demoiselle SourceForge", "http://sf.net/projects/demoiselle"));
			persist(new Bookmark("Twitter", "http://twitter.frameworkdemoiselle.gov.br"));
			persist(new Bookmark("Blog", "http://blog.frameworkdemoiselle.gov.br"));
			persist(new Bookmark("Wiki", "http://wiki.frameworkdemoiselle.gov.br"));
			persist(new Bookmark("Bug Tracking", "http://tracker.frameworkdemoiselle.gov.br"));
			persist(new Bookmark("Forum", "http://forum.frameworkdemoiselle.gov.br"));
			persist(new Bookmark("SVN", "http://svn.frameworkdemoiselle.gov.br"));
			persist(new Bookmark("Maven", "http://repository.frameworkdemoiselle.gov.br"));
			persist(new Bookmark("Downloads", "http://download.frameworkdemoiselle.gov.br"));
		}
	}

	public List<Bookmark> find(String filter) {
		return getDelegate().find(filter);
	}
}
