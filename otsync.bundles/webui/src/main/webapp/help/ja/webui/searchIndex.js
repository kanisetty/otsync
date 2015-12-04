/* "title || helpid | content | file", */
vResults="結果";
profiles = new Array(

/* book */ "OpenText Tempo Box||||index.htm",

/* chapter */ "Web クライアントについて|||Web クライアントについて¶OpenText Tempo Box Web クライアントでは、ブラウザを使用して¶Tempo Box フォルダーのコンテンツにアクセスできます。Web クライアントを使用すれば、¶をしたり、他のユーザーとの¶をすることができます。¶Tempo Box フォルダーを参照するには、フォルダー名をクリックして、その構造内を進んでいきます。パンくずリストのリンクをクリックして前に戻ったり、左画面にある¶すべてのファイル¶をクリックして¶Tempo Box フォルダーのルートにジャンプしたりすることも可能です。¶フォルダーを選択すると、現在表示しているフォルダーの名前とフォルダー所有者が右画面に表示されます。共有フォルダーを選択すると、共同作業者のリストも右画面に表示されます。以下の例では、共有フォルダーの名前が¶Templates¶、フォルダーの所有者名が Peter Day になっています。このフォルダーには 3 人の共同作業者がいます。共有フォルダーの詳細については、次を参照してください。¶.¶複数の共同作業者が存在するフォルダーには、以下のいずれかのアイコンが表示されます。¶OpenText Tempo Box 共有フォルダーのアイコンとオーバーレイ¶アイコン¶説明¶このフォルダー アイコンは、読み取り/書き込みアクセス権を持つ共有フォルダーであることを示します。フォルダー名にユーザー名が付加されている場合は、自分に対して共有が設定されているフォルダーです。例:¶Marketing Materials (jsmith)¶. 詳細については、以下を参照して下さい。¶.¶ロックのオーバーレイは、読み取り専用アクセス権を持つ共有フォルダーであることを示します。詳細については、次を参照してください。¶.¶¶このフォルダー アイコンは、読み取り/書き込みアクセス権を持つエンタープライズ フォルダーであることを示します。Content Server でエンタープライズ フォルダーに登録するか、¶権限の編集¶権限をそのフォルダーに対して持っているユーザーから共有招待を送ってもらえば、 Tempo Box フォルダーからそのコンテンツにアクセスできるようになります。詳細については、次を参照してください。¶.¶¶このフォルダー アイコンのロック オーバーレイは、読み取り専用アクセス権を持つエンタープライズ フォルダーであることを示します。Content Server でエンタープライズ フォルダーに登録するか、¶権限の編集¶権限をそのフォルダーに対して持っているユーザーから共有招待を送ってもらえば、 Tempo Box フォルダーからそのコンテンツにアクセスできるようになります。詳細については、次を参照してください。¶.¶このフォルダー アイコンは、読み取り/書き込みアクセス権を持つ Tempo Social コミュニティのファイル ライブラリであることを示します。 Tempo Social コミュニティのメンバーになれば、 Tempo Box フォルダーからそのファイル ライブラリにアクセスできます。 Tempo Social コミュニティの詳細については、次を参照してください。¶. OpenText Tempo Social は、 OpenText Tempo Box とは別の製品です。 Tempo Social をインストールした環境で Tempo Box フォルダーにそれらのファイル ライブラリが表示されない場合は、管理者にお問い合わせください。¶¶このフォルダー アイコンのロック オーバーレイは、読み取り専用アクセス権を持つ Tempo Social コミュニティのファイル ライブラリであることを示します。詳細については、次を参照してください。¶.¶|sync-icons-bg.htm",

/* sect1 */ "フォルダー表示のフィルター処理|||フォルダー表示のフィルター処理¶フォルダー表示にフィルターを掛けるには:¶左画面で、次のいずれかのリンクをクリックします。¶すべてのファイル¶;ThisIsProcInstr_SpecChar:ndash; Tempo Box フォルダー内のすべてのコンテンツを表示します。¶マイ ファイル¶;ThisIsProcInstr_SpecChar:ndash; 自分が所有しているすべてのファイルとフォルダーを表示します。¶自分と共有¶;ThisIsProcInstr_SpecChar:ndash; 自分に対して共有が設定されているフォルダーだけを表示します。¶エンタープライズ コンテンツ¶;ThisIsProcInstr_SpecChar:ndash; 登録しているエンタープライズ フォルダーを表示します。¶マイ コミュニティ¶;ThisIsProcInstr_SpecChar:ndash; 参加している Tempo Social コミュニティ内のファイル ライブラリを表示します。¶マイ ファイル¶、¶自分と共有¶、¶エンタープライズ コンテンツ¶、¶マイ コミュニティ¶の各フィルターが表示されるのは、そのフィルターの説明に当てはまるフォルダーが 1 つ以上ある場合に限られます。¶|syncpc-filter-p.htm",

/* sect1 */ "フォルダー表示の並べ替え|||フォルダー表示の並べ替え¶フォルダー表示を並べ替えるには:¶該当する列のタイトルをクリックして、名前、最終変更日時、サイズのいずれかに基づいてコンテンツを並べ替えます。¶オプション¶並べ替えの順番を逆にするには、列のタイトルを再度クリックします。¶サムネール表示の場合は、右上隅の¶並べ替える基準¶をポイントして並べ替え方法をクリックします。サムネール表示の詳細については、次を参照してください。¶.¶|syncpcwb-sortfolder-p.htm",

/* sect1 */ "サムネール表示への切り替え|||サムネール表示への切り替え¶サムネール表示に切り替えるには:¶検索¶ボックスの下にある次のアイコンをクリックします。¶.¶オプション¶画像を拡大するには、画像をクリックします。¶次へ¶と¶前へ¶をクリックすると、現在のフォルダーの画像間を移動することができます。サムネール表示に戻るには、画像の外の部分をクリックします。¶オプション¶リスト表示に戻るには、次のアイコンをクリックします。¶.¶|syncpcwb-switchthumbnail-p.htm",

/* sect1 */ "Web クライアントからのサインアウト|||Web クライアントからのサインアウト¶Web クライアントからサインアウトするには:¶右上の画面で自分の名前をクリックし、¶サインアウト¶をクリックします。¶|syncpcwb-logout-p.htm",

/* chapter */ "ファイルとフォルダーの管理|||ファイルとフォルダーの管理¶Web クライアントを使用して、アイテムやフォルダーを¶Tempo Box フォルダーに追加したり、コピーしたり、そのフォルダー内の他の場所に移動したりできます。また、このフォルダー内のアイテムとフォルダーのバージョンや監査履歴を確認したり、名前を変更したり、アイテムとフォルダーを削除したりすることもできます。すべての変更が自動的にオンラインの他のクライアントの¶Tempo Box フォルダーに同期されます。¶Web クライアントを使用して¶Tempo Box フォルダー内のファイルを編集することはできません。Web クライアントを使用してファイルを更新するには、¶そこで編集してから、¶.¶共有フォルダーの移動、名前の変更、または削除の結果は、共有フォルダーの所有者であるかどうかに応じて異なります。詳細については、次を参照してください。¶.¶読み取り/書き込みアクセス権を持つ共有フォルダーのファイルを表示したとき、それらのファイルが自動的に予約されることはありません。共同作業者が変更を加えているとき、同時に他のユーザーも同じファイルをダウンロードして編集することが可能です。そうならないようにするため、¶. 読み取り/書き込みが可能なフォルダーには、次のいずれかのアイコンが表示されます。¶または¶.¶管理者は、¶Tempo Box フォルダーにサイズ制限を設けることができます。フォルダー内のすべてのアイテム (自分に対して共有が設定されているフォルダーのアイテムを除く) のサイズ合計がこの制限を超えた場合は、¶Tempo Box フォルダーのアイテムを削除するか移動して、最大サイズ内に収まるようにしてください。詳細については、次を参照してください。¶.¶Tempo Box フォルダー内の写真や画像には、サムネールが表示されます。もっと大きな画像を見るには、¶その画像を選択します。¶さらに、¶. このオプションを¶. また、エンタープライズ フォルダーに登録していて、そのフォルダーに対する読み取り/書き込みアクセス権を持っているユーザーは、そのフォルダー内のアイテムを直接操作できます。エンタープライズ フォルダーを¶Tempo Box フォルダーに追加する場合の詳細については、以下の項目を参照してください。¶.¶|syncpcwb-fileman-so.htm",

/* sect1 */ "フォルダーの作成|||フォルダーの作成¶フォルダーを作成するには¶フォルダーを作成する場所に移動します。¶読み取り専用アクセス権を持つフォルダー内にフォルダーを作成することはできません。読み取り専用フォルダーにはロックのオーバーレイが表示されます。例:¶、¶.¶中央の画面で、¶新規フォルダー¶をクリックします。¶ボックスにフォルダー名を入力し、¶作成¶をクリックします。¶|syncpcwb-createfolder-p.htm",

/* sect1 */ "アイテムの追加|||アイテムの追加¶アイテムを追加するには:¶アイテムを追加する場所に移動します。¶読み取り専用アクセス権を持つフォルダー内にアイテムを追加することはできません。読み取り専用フォルダーにはロックのオーバーレイが表示されます。例:¶、¶.¶必須のカテゴリや属性のあるフォルダーに Tempo Box でアイテムを追加することはできません。必須のカテゴリや属性のあるフォルダーかどうかを確認する方法については、以下の項目を参照してください。¶.¶中央の画面で、¶ファイルの追加¶をクリックします。¶Tempo Box で取り扱えるのは、2 GB までのファイルに限られます。それより大きいファイルの場合は、操作が失敗します。¶読み取り/書き込みアクセス権を持つフォルダーにコンテンツを追加すると、そのフォルダーへのアクセス権を持つすべてのユーザーにその変更が同期されます。読み取り/書き込みが可能なフォルダーには、次のいずれかのアイコンが表示されます。¶または¶.¶エンタープライズ フォルダー内のコンテンツを編集すると、エンタープライズ ワークスペース内のフォルダーにその変更が同期されます。エンタープライズ フォルダーには、次のアイコンが表示されます。¶.¶以下のいずれかの操作を行います。¶参照¶ボタンが表示される場合は、¶参照¶をクリックし、アイテムを選択して¶アップロード¶をクリックします。¶ファイルのアップロード¶ダイアログ ボックスが表示される場合は、アイテムを選択し、¶開く¶をクリックします。¶サポートされている最新バージョンの Chrome を使用している場合、デスクトップから Web クライアントのブラウザー ウィンドウにファイルをドラッグして追加することもできます。ドラッグできるのはファイルだけで、フォルダーはドラッグできません。ファイルをドラッグすると、ブラウザーにファイルの移動中と表示されていても、常に Web クライアントにはコピーされます。¶|syncpcwb-uploadfile-p.htm",

/* sect1 */ "アイテム バージョンの追加|||アイテム バージョンの追加¶アイテム バージョンを追加するには:¶アイテムの場所に移動します。¶読み取り専用アクセス権を持つフォルダー内のアイテムにバージョンを追加することはできません。読み取り専用フォルダーにはロックのオーバーレイが表示されます。例:¶、¶.¶アイテムのファンクション メニュー¶をポイントして、¶バージョンの追加¶をクリックします。¶そのファイルが他のユーザーによって予約されていると、そのファイルにバージョンを追加することはできません。予約されているファイルには、¶のオーバーレイが表示されます。例:¶. そのファイルを予約したユーザーを確認するには、¶.¶読み取り/書き込みアクセス権を持つ共有フォルダーのファイルにアイテム バージョンを追加するときに、そのファイルが自動的に予約されることはありません。共同作業者が変更を加えているとき、同時に他のユーザーも同じファイルをダウンロードして編集することが可能です。読み取り/書き込みが可能なフォルダーには、次のいずれかのアイコンが表示されます。¶または¶. そうならないようにするため、¶.¶読み取り/書き込みアクセス権を持つフォルダー内のコンテンツを編集すると、そのフォルダーへのアクセス権を持つすべてのユーザーにその変更が同期されます。¶エンタープライズ フォルダー内のコンテンツを編集すると、エンタープライズ ワークスペース内のフォルダーにその変更が同期されます。エンタープライズ フォルダーには、次のアイコンが表示されます。¶.¶以下のいずれかの操作を行います。¶参照¶ボタンが表示される場合は、¶参照¶をクリックし、アイテムを選択して¶バージョンの追加¶をクリックします。¶ファイルのアップロード¶ダイアログ ボックスが表示される場合は、アイテムを選択し、¶開く¶をクリックします。¶|syncpcwb-addversion-p.htm",

/* sect1 */ "アイテムのダウンロード|||アイテムのダウンロード¶アイテムをダウンロードするには¶アイテムのファンクション メニュー¶をポイントして、¶ダウンロード¶をクリックします。¶ブラウザーのファイルのダウンロード方法を使用して、お使いのコンピューターにアイテムを保存します。¶|syncpcwb-downloadfile-p.htm",

/* sect1 */ "ファイルまたはフォルダーの移動またはコピー|||ファイルまたはフォルダーの移動またはコピー¶ファイルを移動またはコピーするには:¶アイテムのファンクション メニュー¶をポイントして、¶移動¶または¶コピー¶をクリックします。¶読み取り専用アクセス権を持つフォルダーからは、ファイルのコピーだけが可能です。読み取り専用フォルダーにはロックのオーバーレイが表示されます。例:¶、¶.¶また、読み取り/書き込みアクセス権を持つフォルダー内のファイルが他の共同作業者によって予約されている場合も、ファイルのコピーだけが可能です。読み取り/書き込みが可能なフォルダーには、次のいずれかのアイコンが表示されます。¶または¶. 予約されているファイルには、¶のオーバーレイが表示されます。例:¶. そのファイルを予約したユーザーを確認するには、そのファイルの監査履歴を調べます。詳細については、次を参照してください。¶.¶ターゲット フォルダーに移動して、¶コピー¶または¶移動¶をクリックします。ターゲット フォルダーがグレー表示になっている場合は、そのフォルダーに対する読み取り/書き込みアクセス権がありません。¶フォルダーを移動またはコピーするには:¶アイテムのファンクション メニュー¶をポイントして、¶移動¶または¶コピー¶をクリックします。¶自身が所有する共有フォルダーは、 Tempo Box フォルダー内のどの場所にも移動できますが、別の共有フォルダーには移動できません。自身が所有する共有フォルダーにはフォルダー名だけが示され、次のアイコンが表示されます。¶.¶自分に対して共有が設定されているフォルダーのルートについては、コピーだけが可能です。その場合は、そのフォルダーのプライベート コピーが新しい場所に作成されますが、元の共有フォルダーは Tempo Box フォルダーのルート レベルに残ります。自分に対して共有が設定されているフォルダーのフォルダー名には、フォルダーの所有者のユーザー名が追加され、¶(読み取り/書き込み) または¶(読み取り専用) が表示されます。¶エンタープライズ フォルダーのルートについては、アクセス レベルにかかわりなく、コピーだけが可能です。また、読み取り専用アクセス権を持つエンタープライズ フォルダー内のサブフォルダーについても、コピーだけが可能です。その場合は、そのフォルダーのプライベート コピーが新しい場所に作成されますが、元のエンタープライズ フォルダーは Tempo Box フォルダーのルート レベルに残ります。エンタープライズ フォルダーには、¶(読み取り/書き込み) または¶(読み取り専用) が表示されます。¶Tempo Social コミュニティ内のファイル ライブラリのルートについては、コピーだけが可能であり、¶(読み取り/書き込み) または¶(読み取り専用) が表示されます。その場合は、そのファイル ライブラリのプライベート コピーが新しい場所に作成されますが、元のファイル ライブラリは Tempo Box フォルダーのルート レベルに残ります。¶共有フォルダーを移動する場合の詳細については、次を参照してください。¶.¶コピーあるいは移動先のフォルダーをクリックし、¶コピー¶または¶移動¶をクリックします。ターゲット フォルダーがグレー表示になっている場合は、そのフォルダーに対する読み取り/書き込みアクセス権がありません。¶複数のアイテムやフォルダーをコピーまたは移動するには、各アイテムまたはフォルダーの左にあるチェック ボックスをオンにして、中央の画面の¶次へ¶をポイントし、¶コピー¶または¶移動¶をクリックします。¶列ヘッダーのチェック ボックスをオンにしてページのすべてのアイテムを選択することもできます。¶|syncpcwb-copymove-p.htm",

/* sect1 */ "ファイルまたはフォルダーの名前の変更|||ファイルまたはフォルダーの名前の変更¶アイテムまたはフォルダーの名前を変更するには:¶アイテムのファンクション メニュー¶をポイントして、¶名前の変更¶をクリックします。¶読み取り専用アクセス権を持つフォルダー内のアイテムまたはフォルダーの名前を変更することはできません。読み取り専用フォルダーにはロックのオーバーレイが表示されます。例:¶、¶.¶共有フォルダー内で他のユーザーによって予約されているファイルの名前を変更することはできません。予約されているファイルには、¶のオーバーレイが表示されます。例:¶. そのファイルを予約したユーザーを確認するには、¶.¶共有フォルダーの名前を変更した場合の結果は、自分がその共有フォルダーの所有者であるかどうかによって異なります。詳細については、次を参照してください。¶.¶読み取り/書き込みアクセス権を持つフォルダー内のコンテンツの名前を変更すると、そのフォルダーへのアクセス権を持つすべてのユーザーにその変更が同期されます。読み取り/書き込みが可能な共有フォルダーには、次のいずれかのアイコンが表示されます。¶または¶.¶新しい名前を入力し、¶名前の変更¶をクリックします。¶|syncpcwb-rename-p.htm",

/* sect1 */ "ファイルの予約と予約解除|||ファイルの予約と予約解除¶ファイルを予約するには:¶アイテムのファンクション メニュー¶をポイントして、¶予約¶をクリックします。¶読み取り専用アクセス権を持つフォルダー内のファイルを予約することはできません。読み取り専用フォルダーにはロックのオーバーレイが表示されます。例:¶、¶.¶読み取り/書き込みアクセス権を持つエンタープライズ フォルダー内のファイルを予約しようとするときに、¶予約¶オプションが有効にならない場合は、 Content Server 内のそのフォルダーに対する¶予約¶権限がありません。この権限をリクエストする場合は、管理者にお問い合わせください。¶予約¶をクリックします。ファイルに¶のオーバーレイが表示されます。例:¶.¶ファイルの予約を解除するには:¶ファイルのファンクション メニュー¶をポイントして、¶予約解除¶をクリックします。¶予約解除¶が有効にならない場合、そのファイルは他のユーザーによって予約されています。そのファイルを予約したユーザーを確認するには、そのファイルの監査履歴を調べます。詳細については、次を参照してください。¶.¶予約解除¶をクリックします。¶|syncpcwb-reserve-p.htm",

/* sect1 */ "ファイルまたはフォルダーの削除|||ファイルまたはフォルダーの削除¶アイテムまたはフォルダーを削除するには:¶アイテムのファンクション メニュー¶をポイントして、¶削除¶をクリックします。¶読み取り専用アクセス権を持つフォルダー内のアイテムを削除することはできません。読み取り専用フォルダーにはロックのオーバーレイが表示されます。例:¶、¶.¶削除¶が有効にならない場合は、自分に対して共有が設定されているフォルダーまたはエンタープライズ フォルダーを選択しています。作業を進める前に、¶を参照してください。¶予約されているファイルを削除することはできません。予約されているファイルには、¶のオーバーレイが表示されます。例:¶. 予約されているファイルを削除するには、まずそのファイルの予約を解除する必要があります。¶予約されているファイルが入っているフォルダーを削除することはできません。ファイルの予約を解除する方法については、次を参照してください。¶.¶削除したアイテムまたはフォルダーが Tempo Box フォルダーから削除されます。つまり、そのアイテムまたはフォルダーが他のすべての OpenText Tempo Box クライアント (デスクトップ クライアント、スマートフォン、タブレットなど) から削除されます。¶読み取り/書き込みアクセス権を持つ共有フォルダー内のコンテンツを削除した場合は、その共有フォルダーの所有者を含め、そのフォルダーへのアクセス権を共有するすべてのユーザーに変更が同期されます。読み取り/書き込みが可能な共有フォルダーには、次のいずれかのアイコンが付けられています。¶または¶.¶読み取り/書き込みアクセス権を持つエンタープライズ フォルダー内のコンテンツを削除すると、エンタープライズ ワークスペース内のフォルダーにその変更が同期されます。エンタープライズ フォルダーには、次のアイコンが表示されます。¶.¶削除¶をクリックします。¶フォルダー内の複数のアイテムやフォルダーを削除するには、各アイテムまたはフォルダーの左にあるチェック ボックスをオンにして、中央の画面の¶次へ¶をポイントし、¶削除¶をクリックします。列ヘッダーのチェック ボックスをオンにしてページのすべてのアイテムを選択することもできます。¶|syncpcwb-delete-p.htm",

/* sect1 */ "共有フォルダーの削除|||共有フォルダーの削除¶所有している共有フォルダーを削除するには:¶対象のフォルダー (次のアイコンが表示されたフォルダー) に移動します。¶.¶アイテムのファンクション メニュー¶をポイントして、¶削除¶をクリックします。¶削除¶が有効にならない場合は、自分に対して共有が設定されているフォルダー、エンタープライズ フォルダー、 Tempo Social コミュニティのファイル ライブラリのいずれかを選択しています。詳細については、以下を参照して下さい。¶,¶、¶.¶そのフォルダーが Tempo Box フォルダーから削除され、自分とすべての共同作業者に影響が及びます。つまり、そのフォルダーが他のすべての OpenText Tempo Box クライアント (デスクトップ クライアント、スマートフォン、タブレットなど) から削除されます。また、共有作業者を削除することもできます。詳細については、次を参照してください。¶.¶削除¶をクリックします。¶自分に対して共有が設定されているフォルダーを削除するには:¶Tempo Box フォルダーのルートで、目的の共有フォルダーを見つけます。自分に対して共有が設定されているフォルダーには、フォルダー名に所有者のユーザー名が付いています。例:¶Marketing Materials (jsmith)¶.¶アイテムのファンクション メニュー¶をポイントして、¶削除¶をクリックします。¶共有フォルダー内のコンテンツではなく、実際のフォルダーを削除する必要があります。共有フォルダー内のコンテンツを削除すると、その共有フォルダーの所有者も含め、すべての共同作業者にとって、そのコンテンツが削除されることになります。¶削除¶をクリックします。¶共有フォルダーへの接続が切断され、そのフォルダーが¶Tempo Box フォルダーから削除されます。これによって所有者または他の共同作業者のフォルダーが削除されることはありません。¶エンタープライズ フォルダーを削除するには:¶Tempo Box フォルダーのルートで、目的のエンタープライズ フォルダーを見つけます。エンタープライズ フォルダーには、次のいずれかのアイコンが表示されます。¶または¶.¶アイテムのファンクション メニュー¶をポイントして、¶削除¶をクリックします。¶エンタープライズ フォルダー内のコンテンツではなく、実際のフォルダーを削除する必要があります。エンタープライズ フォルダー内のコンテンツを削除すると、そのフォルダーに登録していたすべての共同作業者にとってそのコンテンツが削除されることになり、エンタープライズ ワークスペース内のフォルダからもそのコンテンツが削除されます。¶削除¶をクリックします。¶そのフォルダーへの接続が切断され、そのフォルダーが¶Tempo Box フォルダーから削除されます。エンタープライズ ワークスペース内のフォルダーが削除されることはありません。エンタープライズ フォルダーを間違って削除してしまった場合は、エンタープライズ ワークスペース内のフォルダーに移動して、そのフォルダーを再度追加します。エンタープライズ フォルダーを自分の Tempo Box フォルダーに追加する詳細については、次を参照してください。¶.¶Tempo Social コミュニティのファイル ライブラリを削除するには:¶Tempo Box フォルダーのルートで、目的のフォルダーを見つけます。コミュニティ フォルダーには、次のいずれかのアイコンが表示されます。¶または¶.¶アイテムのファンクション メニュー¶をポイントして、¶削除¶をクリックします。¶削除¶をクリックします。¶ファイル ライブラリへの接続が切断され、そのファイル ライブラリが¶Tempo Box フォルダーから削除されます。 Tempo Social フォルダーからそのファイル ライブラリが削除されることはありません。ファイル ライブラリを間違って削除してしまった場合は、 Tempo Social でそのコミュニティに移動して、そのコミュニティに再び参加します。 Tempo Social コミュニティの詳細については、次を参照してください。¶.¶|syncpcwb-delete-shared-folder-p.htm",

/* sect1 */ "アイテムやフォルダーの履歴の表示|||アイテムやフォルダーの履歴の表示¶アイテムやフォルダーの履歴を表示するには:¶アイテムのファンクション メニュー¶をポイントして、¶履歴¶をクリックします。¶アイテムの履歴を表示する場合は、次のいずれかのタブをクリックします。¶監査履歴¶アイテムに対して実行された各アクションが表示されます。¶バージョン履歴¶アイテムの以前のすべてのバージョンのリストが表示されます。以前のバージョンを表示するには、¶ドキュメント名¶をクリックします。フォルダーにはバージョンがありません。¶監査履歴¶の表示だけを行えます。¶監査履歴¶タブの内容は、管理者が監査を有効にしたイベント タイプに応じて異なります。¶|syncpcwb-viewhistory-p.htm",

/* sect1 */ "アイテムやフォルダーの公開|||アイテムやフォルダーの公開¶アイテムまたはフォルダーを公開するには:¶アイテムのファンクション メニュー¶をポイントして、¶公開¶をクリックします。¶このオプションを利用できない場合は、管理者にお問い合わせください。¶はアイテムを Content Server に公開できません。¶アイテムを公開する場合は、次のいずれかをクリックします。¶新しいバージョンの公開¶Content Server で既存のアイテムの新しいバージョンとしてアイテムを追加します。¶フォルダーへの公開¶Content Server のパーソナル ワークスペース、フォルダー、またはプロジェクトなどの場所にアイテムを新しいアイテムとして追加します。¶Content Server の参照¶をクリックし、次のいずれかを選択します。¶アイテムの新しいバージョンを公開する場合は Content Server アイテム。¶新しいアイテムまたはフォルダーを公開する場合は Content Server フォルダー。¶以下のいずれかをクリックします。¶ファイルのコピーの保存¶¶Tempo Box フォルダーの現在のロケーションに既存のアイテムまたはフォルダーを維持します。¶ファイルを Content Server に移動してオリジナルを削除¶Tempo Box フォルダーからアイテムまたはフォルダーを削除します。¶別のユーザーが所有している共有フォルダーを公開する場合は、¶Tempo Box フォルダーにフォルダーのコピーを維持する必要があります。¶公開¶をクリックします。¶|syncpcwb-publish-p.htm",

/* sect1 */ "アイテムまたはフォルダーの検索|||アイテムまたはフォルダーの検索¶アイテムまたはフォルダーを検索するには:¶検索するフォルダーを開きます。¶中央の画面の¶検索¶ボックスに、検索するテキストを入力し、虫眼鏡のアイコンをクリックします。¶.¶アイテムやフォルダーの名前だけを検索できます。システムの構成によっては、検索文字列にワイルドカードとしてアスタリスク (*) を使用できる場合もあります。¶次の表の 1 つまたは複数の操作を実行します。¶目的¶操作¶結果リストの結果を開く¶ファイル名またはフォルダー名をクリックします。¶結果が保存されているフォルダーを開きます。¶見つかりました¶の横にあるフォルダー名をクリックします。¶Tempo Box フォルダーの最上位ビューを表示します。¶左の画面で、¶すべてのファイルに戻る¶をクリックします。¶|syncpcwb-search-p.htm",

/* sect1 */ "Tempo Box フォルダーのサイズの確認|||Tempo Box フォルダーのサイズの確認¶Tempo Box フォルダーのサイズを確認するには:¶右上の画面で自分の名前をクリックし、¶Tempo Box をクリックし、¶設定¶をクリックします。¶ディスク使用状況¶をクリックします。¶Tempo Box フォルダーで使用できる最大のデータ量 (MB) とその最大量に対する使用量のパーセンテージを示した項目が表示されます。¶管理者によって無制限のフォルダー サイズが設定されていると、このタブは表示されません。¶フォルダー サイズが制限を超えた場合は、¶Tempo Box フォルダーのアイテムを削除して、最大サイズに収まるようにしてください。¶|syncpcwb-checkfoldersize-p.htm",

/* chapter */ "フォルダーの共有と共有の招待への応答|||フォルダーの共有と共有の招待への応答¶Tempo Box フォルダーには、共同作業用のフォルダー (共有フォルダー、エンタープライズ フォルダー、コミュニティ ファイル ライブラリ) を組み込むことができます。¶共有フォルダーは、自分が他のユーザーと共有するか、他のユーザーが自分と共有する Tempo Box フォルダーです。フォルダー名にユーザー名が付加されている場合は、自分に対して共有が設定されているフォルダーです。例:¶Marketing Materials (jsmith)¶.¶エンタープライズ フォルダーは、 Tempo Box フォルダーと同期するエンタープライズ ワークスペース内のフォルダーです。そのようなフォルダーに対する¶権限の編集¶権限を持っているユーザーは、そのフォルダーをあなたと共有できます。または、エンタープライズ ワークスペース内のフォルダーに移動して、自分でそのフォルダーを自分の Tempo Box フォルダーに追加することもできます。フォルダーを追加するには、そのフォルダーで Tempo Box の登録が可能な状態になっていることと、少なくとも¶参照¶権限を持っていることが必要です。エンタープライズ フォルダーを自分の Tempo Box フォルダーに追加する詳細については、次を参照してください。¶.¶Tempo Social コミュニティのファイル ライブラリ。コミュニティ ファイル ライブラリが表示されるのは、OpenText Tempo Social がインストールされている場合に限られます。詳細については、管理者にお問い合わせください。¶Tempo Box フォルダー内のフォルダーを共有して、他のユーザーと共同作業を行うことができます。フォルダーを共有するとき、他のユーザーを共同作業者になる可能性のあるユーザーとして追加します。このユーザーは、そのフォルダーに読み取り/書き込み権限または読み取り専用権限を付与したフォルダーにアクセスすることもできます。¶読み取り/書き込みアクセス権を持つ共同作業者は共有フォルダー内のコンテンツのフル コントロールが可能で、共有フォルダー内のアイテムおよびフォルダーの追加、編集、コピー、移動、名前の変更、削除を行うことができます。¶読み取り専用アクセス権の場合、共同作業者は共有フォルダー内のアイテムの表示とコピーができます。読み取り専用権限を持つ共同作業者は、アイテムを編集、移動、削除することができません。読み取り専用権限を持つ共同作業者がアイテムを追加しても、そのアイテムは、他の共同作業者に同期されません。共同作業者がフォルダーに対して読み取り専用アクセス権を持っている場合は、ロック オーバーレイが表示されます。例えば、¶です。¶Tempo Box フォルダー内の任意のフォルダーを共有できますが、次の例外があります。¶ルート¶Tempo Box フォルダー。¶共有フォルダーの子または親であるフォルダー。¶自分に対して共有が設定されているフォルダー。¶読み取り専用アクセス権を持っているエンタープライズ フォルダー。そのフォルダーには¶が表示されます。エンタープライズ フォルダーに対する読み取り/書き込みアクセス権を持っている場合は、¶が表示されます。その場合、 Content Server 内でそのフォルダーに対する¶権限の編集¶権限を持っている場合はそのフォルダーを共有できます。¶読み取り/書き込みアクセス権または読み取り専用アクセス権を持っているコミュニティ ファイル ライブラリ。コミュニティ ファイル ライブラリには、¶と¶が表示されます。¶外部のユーザーは、いかなるフォルダーも共有することはできません。¶共有フォルダー コンテンツへのアクセス¶共同作業者としてそのフォルダーを表示するには、そのフォルダーの所有者から共有招待を受信して受け入れる必要があります。赤の通知¶が上の画面に表示されるのは、保留中の共有招待がある場合です。通知には保留中の招待の数が記されています。受け入れると、その共有フォルダーが Tempo Box フォルダーのルートに置かれ、フォルダー名に所有者のユーザー名が付加されます。例:¶Marketing Materials (jsmith)¶. フォルダーに読み取り/書き込みアクセス権がある場合は¶と表示され、読み取り専用アクセス権がある場合は¶と表示されます。¶エンタープライズ フォルダーへの招待が保留になっている場合にも通知が表示されます。この場合も、そのフォルダーが Tempo Box フォルダーのルートに置かれ、読み取り/書き込みアクセス権がある場合は¶と表示され、読み取り専用アクセス権がある場合は¶と表示されます。 エンタープライズ フォルダーには、親フォルダーへの権限に応じて、親フォルダーの名前が付加される場合があります。例:¶Payroll (Human Resources)¶.¶共有フォルダーの移動、名前の変更、または削除の結果は、共有フォルダーの所有者であるかどうかに応じて異なります。詳細については、次を参照してください。¶.¶読み取り/書き込みアクセス権を持つ共有フォルダー内のアイテムを編集のために開く場合、そのアイテムは自動的には予約されません。複数の共同作業者が同じアイテムを同時に変更できます。そうならないようにするため、編集前にそのファイルを¶できます。自分か共同作業者が変更を保存するたびに、アイテムの新しいバージョンが追加されます。¶エンタープライズ フォルダーの共有¶エンタープライズ フォルダーを共有できるのは、 Content Server でそのフォルダーに対する¶権限の編集¶権限を持っている場合です。フォルダーを共有するとき、フォルダーに読み取り/書き込みアクセス権または読み取り専用アクセス権を付与できます。これにより、 Content Server で次のフォルダー権限レベルが付与されます。¶ Tempo Box でのフォルダー権限とアクセス¶Tempo Box でのアクセス権¶Content Server でのフォルダー権限¶読み取り/書き込みアクセス¶フォルダーのコンテンツを変更する権限。¶権限の編集¶権限以外のすべての権限が含まれます。¶読み取り専用アクセス¶参照¶権限と¶内容の参照¶権限。¶読み取り専用アクセス権を¶参照¶および¶内容の参照¶より高い権限を持つユーザーに付与しようとすると、そのユーザーは現在のアクセス レベルで共有に追加されます。エンタープライズ フォルダーから共同作業者を削除した場合、または共同作業者が Tempo Box フォルダーからフォルダーを削除した場合、付与したアクセス レベルは Content Server に保持されたままになります。¶外部ユーザーとの共有¶エンタープライズ フォルダーを外部ユーザーと共有するには、 OpenText Tempo Box ユーザー アカウントを持っていないユーザーとフォルダーを共有するための権限が必要です。この権限をリクエストするには、管理者にお問い合わせください。さらに、Content Server 内のフォルダーに対する¶権限の編集¶権限も必要です。¶この両方の条件を満たしていればフォルダーを共有できますが、その時にそのユーザーの電子メール アドレスを指定する必要があります。その後、外部ユーザーは、 OpenText Tempo Box アカウントの登録をするための共有招待の電子メールを受け取ります。登録後、外部ユーザーは通常のユーザーと同様にクライアントをインストールし、 OpenText Tempo Box にアクセスすることができますが、いくつかの制限があります。¶外部ユーザーは他のユーザーからの共有招待を受け入れることができますが、外部ユーザーが他のユーザーとフォルダーを共有することはできません。¶外部ユーザーはアイテムを Content Server に公開できず、別の方法でのアクセスもできません。¶|syncpcwb-sharing-so.htm",

/* sect1 */ "フォルダーの共有|||フォルダーの共有¶フォルダーを共有するには:¶アイテムのファンクション メニュー¶をポイントして、¶共有¶をクリックします。¶共有¶メニューがない場合は、このフォルダーを共有する権限がありません。共有できないフォルダーのリストについては、次を参照してください。¶.¶オプション¶フォルダーを共有するとき、共同作業者に、そのフォルダーに対する読み取り/書き込みアクセス権か、読み取り専用アクセス権を与えることができます。デフォルトでは、共同作業者に読み取り/書き込みアクセス権が与えられます。¶読み取り/書き込み¶アクセス権を持つすべての共同作業者 (外部のユーザーも含む) は、共有フォルダーのコンテンツに対するフル コントロールを持っています。ファイルやフォルダーの追加、編集、コピー、移動、名前の変更、削除が可能です。共有フォルダーに修正を加えた後、その変更はそのフォルダーの所有者を含め、共有アクセス権を持つすべての共同作業者と自動的に同期されます。¶読み取り専用アクセス権を持つ¶共同作業者は、共有フォルダーのコンテンツの読み取りとコピーのみを行えます。¶共同作業者に読み取り専用アクセス権を付与するには、¶をクリックしてから、¶読み取り専用¶をクリックします。¶アイコンが表示されます。¶共同作業者¶ボックスをクリックして、このフォルダーを共有する相手の名前を入力します。¶外部ユーザーを招待するには、ユーザーの完全な電子メール アドレスを入力します。外部ユーザーは、会社の従業員ではないユーザーです。有効な電子メール アドレスを入力した後は、オート コンプリートによって外部ユーザーの電子メール アドレスが表示されるようになります。オート コンプリートで電子メール アドレスが表示されない場合は、外部ユーザーとフォルダーを共有する権限がありません。この権限をリクエストするには、管理者にお問い合わせください。外部ユーザーの詳細については、次を参照してください。¶.¶ユーザー名または電子メール アドレスをクリックします。共有の招待が送信されます。共同作業者がフォルダーのコンテンツにアクセスするには、共有の招待を承認する必要があります。¶ステップ 2 ～ 4 を繰り返して、別のユーザーとの共有を設定します。¶保存¶をクリックします。¶フォルダーが共有フォルダーとしてマークされます。共同作業者に読み取り/書き込みアクセス権を与えたか、読み取り専用アクセス権を与えたかには関係なく、共有フォルダーには¶が表示されます。¶フォルダーの共有は、フォルダー名をクリックして、共同作業者を追加することでも行えます。詳細については、次を参照してください。¶.¶|syncpcwb-sharenewfolder-p.htm",

/* sect1 */ "共有招待への応答|||共有招待への応答¶共有の招待に応答するには:¶右上の画面で、共有招待のアイコンをクリックします。¶.¶共有の招待をクリックして、次のいずれかの操作を実行します。¶をクリックして、招待を受け入れます。¶共有フォルダーが¶Tempo Box フォルダーのルートに配置され、読み取り/書き込みアクセス権がある場合は¶と表示され、読み取り専用アクセス権がある場合は¶と表示されます。フォルダー名にはフォルダー所有者のユーザー名が付加されます。例:¶Marketing Materials (jsmith)¶.¶エンタープライズ フォルダーの共有招待を受け入れると、フォルダーは自分の¶Tempo Box フォルダーのルートに配置され、読み取り専用アクセス権がある場合は¶と表示され、読み取り専用アクセス権がある場合は¶と表示されます。自分が持っている権限によっては、エンタープライズ フォルダーにその親フォルダーの名前が付くこともあります。例:¶Payroll (Human Resources)¶.¶をクリックしてから¶辞退¶をクリックして、招待を辞退します。¶すべての共有招待を受け入れる場合は、¶すべてを承認¶をクリックします。¶|syncpcwb-acceptsharereq-p.htm",

/* sect1 */ "共同作業者の権限の変更|||共同作業者の権限の変更¶共同作業者の権限を変更するには:¶所有している共有フォルダーをクリックします。¶右画面の¶共同作業者¶の下で、¶[ ] 人の共同作業者をすべて編集¶をクリックします。¶共同作業者の名前の横にある¶または¶をクリックして、新しい権限を選択します。¶保存¶をクリックします。¶|syncpcwb-readonlyshare-p.htm",

/* sect1 */ "共有フォルダーの共同作業者の更新|||共有フォルダーの共同作業者の更新¶共有フォルダーの共同作業者を更新するには:¶所有している共有フォルダーをクリックします。¶右画面の¶共同作業者¶の下で、次の操作を行います。¶共同作業者を削除するには、その共同作業者の名前の横にある¶をクリックし、¶共有解除¶をクリックします。¶共同作業者を追加するには:¶をクリックし、¶読み取り専用¶をクリックして、読み取り専用の共同作業者を指定します。¶ボックスに、このフォルダーを共有するユーザーの名前を入力します。外部ユーザーの場合は、ユーザーの電子メール アドレスを入力します。¶電子メール アドレスが無視され、オート コンプリートで電子メール アドレスの表示ができなかった場合、外部ユーザーとのフォルダー共有権限がありません。この権限をリクエストするには、管理者にお問い合わせください。外部ユーザーの詳細については、次を参照してください。¶.¶ユーザー名または電子メール アドレスをクリックします。共有の招待が送信されます。共同作業者がフォルダーのコンテンツにアクセスするには、共有の招待を承認する必要があります。¶1 つのフォルダーに 7 人を超える共同作業者がいる場合は、¶[ ] 人の共同作業者をすべて編集¶をクリックして、共同作業者を更新してください。¶|syncpcwb-updatecollab-p.htm",

/* sect1 */ "共有フォルダーからの共同作業者の削除|||共有フォルダーからの共同作業者の削除¶共有フォルダーから共同作業者を削除するには:¶所有している共有フォルダーをクリックします。¶右画面の¶共同作業者¶の下で、共同作業者の名前の横にある¶をクリックし、¶共有解除¶をクリックします。¶1 つのフォルダーに 7 人を超える共同作業者がいる場合は、¶[ ] 人の共同作業者をすべて編集¶をクリックし、共同作業者の名前の横にある¶をクリックし、¶保存¶をクリックします。¶すべての共同作業者のフォルダーを共有解除するには、¶共有をすべて解除¶をクリックします。¶別のユーザーから自分に対して共有が設定されているフォルダーを表示する必要がなくなった場合は、その共有フォルダーを削除できます。共有フォルダーだけを削除する必要があります。共有フォルダー内のコンテンツを削除すると、すべての共同作業者にとってそのコンテンツが削除されます。別のユーザーから自分に対して共有が設定されている共有フォルダーを削除する場合の詳細については、次を参照してください。¶.¶|syncpcwb-unsharefolder-p.htm",

/* sect1 */ "共有フォルダーに関する電子メール通知の有効化|||共有フォルダーに関する電子メール通知の有効化¶共有フォルダーの電子メール通知を有効にするには:¶所有していない共有フォルダーをクリックします。¶右画面で、¶フォルダー通知を受信する¶チェック ボックスを選択します。¶Content Server プロファイルの¶電子メール¶フィールドで指定したアドレスに電子メール通知が送信されます。通知を受信できない場合は、管理者にお問い合わせください。外部ユーザーの場合は、 Tempo Box アカウントにサインインした時に使用した電子メール アドレスに電子メールが送信されます。¶このオプションを使用できるのは、管理者が電子メール通知を有効にして、ユーザー自身が電子メール通知を受け取るためのグローバル オプションを無効にした場合に限られます。グローバル オプションの詳細については、次を参照してください。¶.¶|syncpcwb-emailnotsharedfolder-p.htm",

/* sect1 */ "共有フォルダーの移動、名前の変更、および削除|||共有フォルダーの移動、名前の変更、および削除¶所有している共有フォルダーには次の条件が適用されます。¶共有フォルダーを Tempo Box フォルダー内の別の場所に移動する場合は、他のすべての共同作業者による共有の状態が維持されます。¶共有フォルダーを Tempo Box フォルダー外の場所に移動すると、そのフォルダーは共有されなくなり、他の共同作業者がそのフォルダーを表示できなくなります。そのフォルダーは通常のフォルダーになって、そのコンテンツが Tempo Box フォルダーから削除されます。¶共有フォルダーの名前を変更すると、他のすべての共同作業者に表示される名前も変更されます。¶共有フォルダーを削除すると、他のすべての共同作業者からも削除されます。¶アクセス権を持っているものの、所有していない共有フォルダーには次の条件が適用されます。¶共有フォルダー、エンタープライズ フォルダー、およびコミュニティ ファイル ライブラリのルートを移動することはできません。¶自分のユーザー名フォルダーの外に共有フォルダーを移動すると、そのフォルダーの自分に対する共有はなくなります。フォルダーは通常のフォルダーになり、同期されなくなります。フォルダーを自分のユーザー名フォルダーの外部に誤って移動した場合、フォルダー所有者に連絡して、新しい共有招待を送信してもらう必要があります。¶共有フォルダーのルートの名前を変更することはできません。¶共有フォルダーを削除した場合、そのフォルダーは Tempo Box フォルダーから削除されるだけです。他の共同作業者は引き続きそのフォルダーにアクセスできます。フォルダーを誤って削除した場合、フォルダー所有者に連絡して、新しい共有招待を送信してもらう必要があります。¶エンタープライズ フォルダーを削除した場合、そのフォルダーは Tempo Box フォルダーから削除されるだけです。他の共同作業者は引き続きそのフォルダーにアクセスできます。そのフォルダーを間違って削除した場合は、 Content Server エンタープライズ ワークスペースからそのフォルダーを再び追加できます。エンタープライズ フォルダーを自分の Tempo Box フォルダーに追加する方法については、次を参照してください。¶.¶エンタープライズ フォルダーのルートの名前は、そのフォルダーへの¶権限の編集¶権限を持っている場合以外変更できません。¶Tempo Social コミュニティ内のファイル ライブラリのルートを移動したり、その名前を変更したりすることはできません。¶|syncpc-renamedelmoveshare-bg.htm",

/* chapter */ "設定の指定|||設定の指定¶右上の画面で自分の名前をクリックすると、以下の操作を行うためのメニューが表示されます。¶自分に対して共有が設定されているフォルダーを表示するときに他のユーザーが見る写真を更新します。¶共有フォルダーの招待を受けたときや、共有フォルダーが更新されたときの OpenText Tempo Box の通知を設定します。電子メールの通知を受け取るには、管理者にその機能を有効にしてもらう必要があります。¶バージョン情報を表示します。¶Web クライアントからサインアウトします。¶|syncpcwb-settings-so.htm",

/* sect1 */ "写真の更新|||写真の更新¶写真を更新するには:¶右上の画面で自分の名前をクリックし、¶プロファイル¶をクリックします。¶以下のいずれかの操作を行います。¶参照¶をクリックして、使用する写真を選択します。¶写真は、¶.png¶,¶.gif¶、または¶.jpg¶のいずれかの形式でなければなりません。ディスプレイで利用できるスペースに合わせる必要がある場合は、サイズが調整され、トリミングされます。¶一般的なプロファイル画像を使用する場合は、¶デフォルトを使用¶をクリックします。¶変更を保存¶をクリックします。¶OpenText  Content Server Pulse を使用する場合、 OpenText Tempo Box の写真を更新すると、¶Pulse プロファイル¶の写真も更新されます。¶|syncpcwb-updatephoto-p.htm",

/* sect1 */ "電子メール通知の有効化|||電子メール通知の有効化¶電子メール通知を有効にするには:¶右上の画面で自分の名前をクリックし、¶Tempo Box をクリックし、¶設定¶をクリックします。¶自分に電子メールを送信¶の下で、次のチェック ボックスのいずれかまたは両方を選択します。¶通知の受信時 共有要求¶¶別のユーザーからフォルダーの共有を招待されたときに電子メールを受け取ります。¶他のユーザーが通知を作成時 変更 任意の共有フォルダーへ¶参加者となっている共有フォルダーのアイテムを別のユーザーが追加、編集、または削除したときに通知のメールを受け取ります。メールの定期的なサマリーは、管理者が設定したスケジュールで送信されます。この設定は、共有しているすべてのフォルダー全体に適用されます。この設定を有効にしない場合でも、個々の共有フォルダーについて電子メール通知を受け取ることができます。詳細については、次を参照してください。¶.¶このオプションを使用するには、管理者が電子メール通知を有効にする必要があります。¶設定を保存¶をクリックします。 Content Server プロファイルの¶電子メール¶フィールドに指定したアドレスにメールが送信されます。通知を受信できない場合は、管理者にお問い合わせください。外部ユーザーの場合は、 Tempo Box にサインインした時に使用した電子メール アドレスに電子メールが送信されます。¶|syncpcwb-enableemailnot-p.htm",

/* sect1 */ "Web クライアントのバージョン情報の表示|||Web クライアントのバージョン情報の表示¶Web クライアントのバージョン情報を表示するには:¶右上の画面で自分の名前をクリックします。¶Tempo Box >¶バージョン情報¶をクリックします。¶|syncpcwb-viewversion-p.htm",

"||||"
);
profileMatch = new Array();
