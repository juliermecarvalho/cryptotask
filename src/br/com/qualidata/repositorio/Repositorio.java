package br.com.qualidata.repositorio;

import java.sql.SQLException;
import java.util.List;

import br.com.qualidata.dao.IDao;
import br.com.qualidata.dao.Instalacao;
import br.com.qualidata.dao.Mensagem;
import br.com.qualidata.dao.Pessoa;
import br.com.qualidata.dao.Tarefa;

import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.android.AndroidDatabaseConnection;
import com.j256.ormlite.android.DatabaseTableConfigUtil;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableUtils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public abstract class Repositorio<Entity extends IDao> extends SQLiteOpenHelper {

	protected static AndroidConnectionSource connectionSource;

	private static final String DATABASE_NAME = "cryptotask.db";
	private static final int DATABASE_VERSION = 1;
	protected Dao<Entity, Integer> dao;
	protected Class<Entity> type;

	public Repositorio(Context context, Class<Entity> type) throws SQLException {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		if (connectionSource == null) {
			connectionSource = new AndroidConnectionSource(this);
		}
		this.type = type;
		this.dao = this.getDao(type);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		DatabaseConnection conn = connectionSource.getSpecialConnection();
		boolean clearSpecial = false;
		if (conn == null) {
			conn = new AndroidDatabaseConnection(db, true);
			try {
				connectionSource.saveSpecialConnection(conn);
				clearSpecial = true;
			} catch (SQLException e) {
				throw new IllegalStateException(
						"Could not save special connection", e);
			}
		}
		try {
			onCreate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (clearSpecial) {
				connectionSource.clearSpecialConnection(conn);
			}
		}
	}

	protected void onCreate() throws SQLException {
		Log.i(Repositorio.class.getName(), "onCreate");
		TableUtils.createTableIfNotExists(connectionSource, Pessoa.class);
		TableUtils.createTableIfNotExists(connectionSource, Instalacao.class);
		TableUtils.createTableIfNotExists(connectionSource, Tarefa.class);
		TableUtils.createTableIfNotExists(connectionSource, Mensagem.class);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		DatabaseConnection conn = connectionSource.getSpecialConnection();
		boolean clearSpecial = false;
		if (conn == null) {
			conn = new AndroidDatabaseConnection(db, true);
			try {
				connectionSource.saveSpecialConnection(conn);
				clearSpecial = true;
			} catch (SQLException e) {
				throw new IllegalStateException(
						"Could not save special connection", e);
			}
		}
		try {
			onUpgrade(oldVersion, newVersion);
		} finally {
			if (clearSpecial) {
				connectionSource.clearSpecialConnection(conn);
			}
		}
	}

	private void onUpgrade(int oldVersion, int newVersion) {
		try {
			Log.i(Repositorio.class.getName(), "onUpgrade");
			TableUtils.createTableIfNotExists(connectionSource, Mensagem.class);
			TableUtils.createTableIfNotExists(connectionSource, Tarefa.class);
			TableUtils.createTableIfNotExists(connectionSource, Instalacao.class);
			TableUtils.createTableIfNotExists(connectionSource, Pessoa.class);			
			onCreate();
		} catch (SQLException e) {
			Log.e(Repositorio.class.getName(), "Can't drop databases", e);
			throw new RuntimeException(e);
		}
	}

	public <D extends Dao<T, ?>, T> D getDao() throws SQLException {
		return this.getDao(type);
	}

	public void createOrUpdate(Entity entity) throws SQLException {
		this.dao.createOrUpdate(entity);
	}

	public void delete(Entity entity) throws SQLException {
		if (this.dao.idExists(entity.getId())) {
			this.dao.delete(entity);
		}
	}

	public void deleteById(int id) throws SQLException {
		if (this.dao.idExists(id)) {
			this.dao.deleteById(id);
		}
	}

	public Entity getById(int id) throws SQLException {
		return this.dao.queryForId(id);
	}

	public List<Entity> getAll() throws SQLException {
		return this.dao.queryForAll();
	}

	private <D extends Dao<T, ?>, T> D getDao(Class<T> clazz)
			throws SQLException {
		Dao<T, ?> d = DaoManager.lookupDao(connectionSource, clazz);
		if (d == null) {
			// try to use our new reflection magic
			DatabaseTableConfig<T> tableConfig = DatabaseTableConfigUtil
					.fromClass(connectionSource, clazz);
			if (tableConfig == null) {
				/**
				 * TODO: we have to do this to get to see if they are using the
				 * deprecated annotations like {@link DatabaseFieldSimple}.
				 */
				d = DaoManager.createDao(connectionSource, clazz);
			} else {
				d = DaoManager.createDao(connectionSource, tableConfig);
			}
		}

		@SuppressWarnings("unchecked")
		D castDao = (D) d;
		return castDao;
	}

}
