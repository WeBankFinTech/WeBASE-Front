export default {
    project: {
        name: 'Node Console',
        blocks: 'Blocks',
        nodes: 'Nodes',
        transactions: 'Transactions',
        pendingTransactions: 'Pending Transactions',
    },
    route: {
        statistics: 'Overview',
        nodeManagement: 'Node Mgmt',
        nodeManagementQ: 'Node Management',
        contractManagement: 'Contract Mgmt',
        contractManagementQ: 'Contract Management',
        contractIDE: 'Contract IDE',
        contractList: 'Contract List',
        systemMonitoring: 'System Metrics',
        hostMetrics: 'Host Metrics',
        nodeMetrics: 'Node Metrics',
        privateKeyManagement: 'Private Key Mgmt',
        privateKeyManagementQ: 'Private Key Management',
        subscribeEvent: 'Subscribe Event',
        blockEvent: 'Block Event',
        contractEvent: 'Contract Event',
        testUserList: 'Test User'
    },
    navbar: {
        dashboard: 'Dashboard',
        github: 'Github',
        logOut: 'Log Out',
        profile: 'Profile',
        theme: 'Theme',
        size: 'Global Size'
    },
    documentation: {
        documentation: 'Documentation',
        github: 'Github Repository'
    },
    permission: {
        addRole: 'New Role',
        editPermission: 'Edit',
        roles: 'Your roles',
        switchRoles: 'Switch roles',
        tips: 'tips',
        delete: 'Delete',
        confirm: 'Confirm',
        cancel: 'Cancel'
    },
    components: {
        documentation: 'Documentation',
        tinymceTips: 'Rich text is a core feature of the management backend, but at the same time it is a place with lots of pits. In the process of selecting rich texts, I also took a lot of detours. The common rich texts on the market have been basically used, and I finally chose Tinymce. See the more detailed rich text comparison and introduction.',
        dropzoneTips: 'Because my business has special needs, and has to upload images to qiniu, so instead of a third party, I chose encapsulate it by myself. It is very simple, you can see the detail code in @/components/Dropzone.',
        stickyTips: 'when the page is scrolled to the preset position will be sticky on the top.',
        backToTopTips1: 'When the page is scrolled to the specified position, the Back to Top button appears in the lower right corner',
        backToTopTips2: 'You can customize the style of the button, show / hide, height of appearance, height of the return. If you need a text prompt, you can use element-ui el-tooltip elements externally',
        imageUploadTips: 'Since I was using only the vue@1 version, and it is not compatible with mockjs at the moment, I modified it myself, and if you are going to use it, it is better to use official version.'
    },
    table: {
        type: 'Type',
        search: 'Search',
        addUser: 'Add User',
        importPrivateKey: 'Import Private Key',
        export: 'Export',
        id: 'ID',
        date: 'Date',
        status: 'Status',
        actions: 'Actions',
        edit: 'Edit',
        publish: 'Publish',
        delete: 'Delete',
        cancel: 'Cancel',
        confirm: 'Confirm',
        nodeId: 'Node ID',
        blockHeight: 'Block Height',
        pbftView: 'Pbft View',
        run: 'Run',
        abnormal: 'Abnormal',
        address: 'Address',
        publicKey: 'Public Key',
        user: 'User',
        transactionHash: 'Transaction Hash',
        transactionInfo: 'Transaction Info',
        transactionReceipt: 'Transaction Receipt',
        contractName: 'Name',
        contractPath: 'Location',
        contractAddress: 'Address',
        contractAbi: 'Abi',
        contractBin: 'Bin',
        createdTime: 'Created Time',
        importPem: "Import Pem Private Key",
        addBlockEvent: "Add Block Event",
        addContractEvent: "add contract Event",
        blockEventInfo: "Event Info",
        appId: "App Id",
        exchangeName: "Exchange",
        queueName: "Queue Name",
        routingKey: "RoutingKey",
        groupId: "Group Id",
        fromBlock: 'From Block',
        toBlock: 'To Block',
        topicList: 'Topic List'
    },
    errorLog: {
        tips: 'Please click the bug icon in the upper right corner',
        description: 'Now the management system are basically the form of the spa, it enhances the user experience, but it also increases the possibility of page problems, a small negligence may lead to the entire page deadlock. Fortunately Vue provides a way to catch handling exceptions, where you can handle errors or report exceptions.',
        documentation: 'Document introduction'
    },
    excel: {
        export: 'Export',
        selectedExport: 'Export Selected Items',
        placeholder: 'Please enter the file name (default excel-list)'
    },
    zip: {
        export: 'Export',
        placeholder: 'Please enter the file name (default file)'
    },
    pdf: {
        tips: 'Here we use window.print() to implement the feature of downloading PDF.'
    },
    notice: {
        copySuccessfully: 'Copy successfully',
        copyFailure: 'Copy failed, key is empty'
    },
    dialog: {
        addUsername: 'Add Username',
        pleaseEnterUserName: 'Please type in username',
        rivateKeyVerifyLength: 'The length is between 3 and 32 characters',
        rivateKeyVerifyLength1_32: 'The length is between 1 and 32 characters',
        rivateKeyVerifyFont: 'Can only be composed of numbers or letters',
        rename: 'Rename',
        newFile: 'NewFile',
        delete: 'Delete',
        exportJavaNote: 'Note: Package name must equal to contract name',
        delete: 'Delete',
        cancel: 'Cancel',
        confirm: 'Confirm',
        sureExport: 'Sure Export',
        sureDelete: 'Sure Delete',
        contractNameIllegal: 'Contract name illegal',
        folderNameIllegal: 'Folder name illegal',
        folderName: 'Folder Name',
        pleaseType: 'Please type in',
        appId: "Please enter the application number",
        exchangeName: "Please enter the exchange name",
        queueName: "Please enter the queue name",
        groupId: "Please enter the group id",
        contractAbi: "Please enter contract Abi",
        contractAddress: "Please enter contract address",
        fromBlock: "Please enter from block",
        toBlock: "Please enter to block",
        topicList: "Please enter topic List",
    },
    placeholder: {
        globalSearch: 'Search by Block / Txn Hash',
        javaPackage: 'Example: com.webank',
        selected: 'select',
        selectedAccountAddress: 'Select Account Address',
        selectedNoUser: 'No available user, please create a new user in private key management panel',
        selectedContractAddress: 'Select Contract Address',
        functionName: 'Function Name',
        contractListSearch: 'Search by Name / Address',
        selectedDay: 'Pick a day',
        selectedTimeRange: 'Select Time Range',
        to: 'to',
        startTime: 'Start Time',
        endTime: 'End Time',
    },
    title: {
        copyHash: 'Copy Hash',
        copy: 'Copy',
        copyAddress: 'Copy Address',
        copyPubliceKey: 'Copy Publice Key',
        copyContractAddress: 'Copy Contract Address',
        copyContractName: 'Copy Contract Name',
        copyAbi: 'Copy Abi',
        copyBin: 'Copy Bin',
        newFile: 'New File',
        newFolder: 'New Folder',
        upload: 'Upload',
        save: 'Save',
        compile: 'Compile',
        deploy: 'Deploy',
        callContract: 'Call Contract',
        exportJavaFile: 'Export as Java File',
        handleSave: 'Ctrl+s Save',
        handleCompile: 'Alt+c Compile',
        handleDeploy: 'Alt+d Deploy',
        handleCallContract: 'Alt+t Call Contract',
        selectAccountAddress: 'Select Account Address',
        writeJavaName: 'Java Package Name',
        selectDirectory: 'Select Directory',
        txnContractAddExp: 'Optional，Import deployed contract address',
        restore: 'Restore',
        zoom: 'Zoom',
        back: 'Back',
        stack: 'Stack',
        tiled: 'Tiled',
        detailsAbi: 'Details Abi',
        detailsTxn: 'Transactions Details',
        acquisitionSwitch: 'Acquisition switch',
        check: 'check',
        detele: 'detele'
    },
    text: {
        noContract: 'Please create a new contract',
        hide: 'Hide',
        expand: 'Expand',
        compilationFailed: 'Contract was not compiled or failed to compile',
        compilationSucceeded: 'Contract compilation succeeded',
        compilationBegin: 'Contract starts to compile.',
        compiling: 'Contract compiling ...',
        contractFileName: 'Contract name must equal to file name',
        saveFailed: 'Save failed',
        saveSucceeded: 'Save succeeded',
        deploySucceeded: 'Deploy succeeded',
        deployFailed: 'Deploy failed',
        redeploy: 'Contract has been modified, please re-deploy',
        systemError: 'System Error',
        contractSameDirectory: 'Contract name must be unique under the same directory',
        unsavedContract: 'Contract modifed and unsaved. Save',
        contractName: 'Contract Name',
        filePath: 'File Path',
        pleaseEnter: 'Please type in',
        errorNewFolderName: 'Error：Folder already exists',
        contractAddress: 'Contract Address',
        acountAddress: 'Account Address',
        parame: 'Parame',
        deployParameVec: 'If paramaters are arrays , separated by ","',
        searchSucceeded: 'Query successfully',
        txnSucceeded: 'Transaction succeeded',
        txnFailed: 'Transaction failed',
        sendFailed: 'Send transaction failed',
        sendFunction: 'function',
        showDate: 'Show Date',
        comparingDate: 'Comparing By Date',
        fromTo: 'From/to',
        dataGranularity: 'Data Granularity',
        minutes: 'Min',
        seconds: 'Sec',
        confirm: 'Confirm',
        usage: ' Usage',
        hardDisk: ' Hard Disk',
        memory: ' MEM',
        uplink: ' Uplink',
        downlink: ' Downlink',
        bandwidth: ' Bandwidth',
        blockHeight: 'Block Height',
        pendingTransactions: 'Pending Transactions',
        comparingByDay: 'Comparing By Day',
        noMetrics: 'Data uncollected or data is empty',
        showByDay: 'Show By Day',
        searchEmpty: 'The query result is empty',
        noData: 'No Data',
        importSuccessed: 'Import Successed',
        importFailed: 'Import Failed',
        addUserSuccessed: 'Create successed',
        deleteUserSuccessed: 'Delete successed',
        nameNoSame: 'User names cannot be the same',
        uploadSol: 'Please upload contract files(extension: .sol)',
        fileExceeds: 'File size exceeds 400k, please upload files smaller than 400k',
        txnDecodeBtn: 'Decode',
        txnEncodeBtn: 'Restore',
        toggleSuccessed: 'Switch successed',
        toggleFailed: 'Switch failed',
        toggleOpen: 'Open',
        toggleDown: 'Down',
        privateKeyManagementInfo: "Support for exporting private keys, you can export private keys to local.",
        FileName: "privateKey Name",
        importFile: "Import File",
        pemName: "Pem File Name",
        appId: "Unique number of the application that registered the event notification",
        exchangeName: "Switch to which the queue belongs",
        queueName: "User name is usually used as the queue name",
        contractAbi: "ABI of contract, used for contract event analysis;for example, [HelloWorld (string)]",
        contractAddress: "Contract address",
        fromBlock: "The minimum value is 0; the default value is latest, which means listening to the latest block",
        toBlock: "The minimum value is 0; the default value is latest, which means listening to the latest block",
        topicList: "List of contract event names, separated by English commas without spaces; for example, HelloWorld, asset",
    }
}
